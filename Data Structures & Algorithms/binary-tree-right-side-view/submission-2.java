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
    List<Integer> res = new ArrayList();

    public List<Integer> rightSideView(TreeNode root) {
        return bfs(root);
    }
    public List<Integer> bfs(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) return result;
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        queue.offerFirst(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Integer side = null;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.pollLast();
                side = current.val;
                if (current.left != null) {
                    queue.offerFirst(current.left);
                }
                if (current.right != null) {
                    queue.offerFirst(current.right);
                }
            }
            result.add(side);
        }
        return result;
    }
    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        // if depth already seen, dont add. As a righter node already exists.
        if (res.size() == depth) {
            res.add(root.val);
        }
        // Check right
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);

    }

}
