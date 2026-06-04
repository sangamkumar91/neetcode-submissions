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
        System.out.println(current.word);
        current.word = word;
    }

    public boolean search(String word) {
        Node current = root;
        for (char c: word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
            System.out.println(current.word);
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
            System.out.println(current.c);
            System.out.println(current.word);
        }
        if (current.word != null) return true;
        for (Node n : current.children)
            if (n != null) return true;

        return false;
    }
}

class Node {
    char c;
    String word;
    Node[] children = new Node[26];
}
