/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> dup = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (dup.containsKey(node)) return dup.get(node);

        Node d = new Node(node.val);
        dup.put(node, d);
        for (Node neigh : node.neighbors) {
            d.neighbors.add(cloneGraph(neigh));
        }
        return d;
    }
}