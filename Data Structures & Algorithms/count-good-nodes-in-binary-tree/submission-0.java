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
    int result = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        goodNodes(root, Integer.MIN_VALUE);
        return result;
    }

    public void goodNodes(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) result++;
        goodNodes(root.left, Math.max(max, root.val));
        goodNodes(root.right, Math.max(max, root.val));
    }

}
