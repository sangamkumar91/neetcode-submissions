/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // One Pass Soultion with addition memory.
    // Another 2 Pass solution without additonal memory is to place copied nodes alternate to the original node. 
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> copy = new HashMap();
        Node current = head;
        while(current != null) {
            copy.putIfAbsent(current, new Node(current.val));
            if (current.next != null)
                copy.putIfAbsent(current.next, new Node(current.next.val));
            if (current.random != null)
                copy.putIfAbsent(current.random, new Node(current.random.val));

            copy.get(current).next = copy.get(current.next);
            copy.get(current).random = copy.get(current.random);
            current = current.next;
        }

        return copy.get(head);
    }
}
