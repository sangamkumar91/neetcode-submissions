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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSumFromRoot(root);
        return result;
    }

    public int maxSumFromRoot(TreeNode root) {
        if (root == null) return 0;
        int val = root.val;
        int left = maxSumFromRoot(root.left);
        int right = maxSumFromRoot(root.right);

        result = Math.max(result, val);
        result = Math.max(result, left + val);
        result = Math.max(result, right + val);
        result = Math.max(result, left + right + val);
        System.out.println("val");
        System.out.println(val);
        System.out.println("left");
        System.out.println(left);
        System.out.println("right");
        System.out.println(right);
        System.out.println("result");
        System.out.println(result);
        return Math.max(val, Math.max(left + val, right + val));
    }
}
