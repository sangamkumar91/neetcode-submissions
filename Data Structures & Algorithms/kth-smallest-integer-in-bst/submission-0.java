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
    public int kthSmallest(TreeNode root, int k) {
        Integer[] memo = new Integer[] {k, null};
        dfs(root, memo);    
        return memo[1];
    }
    public void dfs(TreeNode root, Integer[] memo) {
        if (root == null) {
            return;
        }
        dfs(root.left, memo);
        if (memo[0] == 0) return;
        memo[0]--;
        memo[1] = root.val;
        if (memo[0] == 0) return;
        dfs(root.right, memo);
    }
}
