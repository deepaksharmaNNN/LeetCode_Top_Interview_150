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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        if(root.left == null && root.right == null) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            list.add(temp);
            return list;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean flag = false;
        while(!que.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = que.size();
            while(size-- > 0){
                TreeNode curr = que.poll();
                temp.add(curr.val);
                if(curr.left != null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);
            }
            if(flag){
                Collections.reverse(temp);
            }
            list.add(temp);
            flag = !flag;
        }
        return list;
    }
}