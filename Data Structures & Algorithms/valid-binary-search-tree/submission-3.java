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
    Stack<TreeNode> stack = new Stack();

    public boolean isValidBST(TreeNode root) {
        return isValidBST_O_Of_h(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean isValidBST_O_Of_n(TreeNode root) {

        // Pre Order
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (!left) return false;
        if (!stack.isEmpty() && stack.peek().val >= root.val)
            return false;
        stack.push(root);
        boolean right = isValidBST(root.right);
        return right;
    }
    public boolean isValidBST_O_Of_h(TreeNode root, int min, int max) {

        // Pre Order
        if (root == null) return true;
        int val = root.val;
        if (val <= min || val >= max) return false;
        boolean left = isValidBST_O_Of_h(root.left, min, val);
        if (left)
            return isValidBST_O_Of_h(root.right, val, max);
        return left;
    }

}
