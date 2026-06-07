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

public class Codec {

    // This is through BFS. Use stack during desiralization if doing DFS
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> levelOrder = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                levelOrder.add(null);
                continue;
            }
            levelOrder.add(current.val);
            queue.offer(current.left);
            queue.offer(current.right);
        }

        return levelOrder.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if (data.equals("null")) return null;
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0].trim()));
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (!nodes[i].trim().equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i].trim()));
                queue.offer(current.left);
            }
            i++;
            if (!nodes[i].trim().equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i].trim()));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
}
