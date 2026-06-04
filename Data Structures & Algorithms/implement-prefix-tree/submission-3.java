class PrefixTree {

    Node root = new Node();
    public PrefixTree() {
         
    }

    public void insert(String word) {
        Node current = root;
        for (char c: word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                Node n = new Node();
                n.c = c;
                current.children[c - 'a'] = n;
            }
            current = current.children[c - 'a'];
        }
        current.word = word;
    }

    public boolean search(String word) {
        Node current = root;
        for (char c: word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return current.word != null;
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        for (char c: prefix.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return true;
    }
}

class Node {
    char c;
    String word;
    Node[] children = new Node[26];
}
