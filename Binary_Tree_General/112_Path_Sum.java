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
    private boolean helper(TreeNode root, int target, int total) {
        if (root == null) return false;
        total += root.val;
        if (root.left == null && root.right == null) { 
            return total == target;
        }
        // check left and right subtree
        return helper(root.left, target, total) || helper(root.right, target, total);
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return helper(root, targetSum, 0);
    }
}