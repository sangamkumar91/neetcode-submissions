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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        List<List<Integer>> result = new ArrayList();
        if (root == null) return result;
        while(!q.isEmpty()) {
            List<Integer> current = new ArrayList();
            int size = q.size();
            while (size > 0) {
                TreeNode x = q.poll();
                current.add(x.val);
                if (x.left != null) {
                    q.offer(x.left);
                }
                if (x.right != null) {
                    q.offer(x.right);
                }
                size--;
            }
            result.add(current);
        }
        return result;
        
    }
}
