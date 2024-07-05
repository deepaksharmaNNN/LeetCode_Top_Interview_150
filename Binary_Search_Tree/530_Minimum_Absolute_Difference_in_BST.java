/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void getMin(TreeNode root, TreeNode min, TreeNode prev){
        if(root == null) return;
        getMin(root.left, min, prev);
        min.val = Math.min(min.val, Math.abs(root.val - prev.val));
        prev.val = root.val;
        getMin(root.right, min, prev);

    }
    public int getMinimumDifference(TreeNode root) {
        TreeNode min = new TreeNode(Integer.MAX_VALUE);
        TreeNode prev = new TreeNode(Integer.MAX_VALUE);
        getMin(root, min, prev);
        return min.val;
    }
}