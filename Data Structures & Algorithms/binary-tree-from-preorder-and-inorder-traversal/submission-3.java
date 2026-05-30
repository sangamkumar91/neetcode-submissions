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
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < inorder.length ; i++)
            map.put(inorder[i], i);
        return getRoot(preorder, inorder, 0, inorder.length -1, 0);
    }

    public TreeNode getRoot(int[] preorder, int[] inorder, int start, int end, int index) {
        if (index == inorder.length) return null;

        int val = preorder[index];

        // Place in inorder matrix
        int mid = map.getOrDefault(val, -1);

        if (mid == -1 || mid < start || mid > end) return null;
        // We need to see after left subtree is constructed,
        // we need the size for the starting index of right subtree
        int leftSubtreeSize = mid - start;
        TreeNode left = getRoot(preorder, inorder, start, mid - 1, index + 1);
        
        
        TreeNode right = getRoot(preorder, inorder, mid + 1, end, index + leftSubtreeSize + 1);

        return new TreeNode(
            val,
            left,
            right
        );
    }

}
