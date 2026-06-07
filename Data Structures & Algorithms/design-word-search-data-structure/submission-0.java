class WordDictionary {
    TrieNode root = new TrieNode('.');
    public WordDictionary() {
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            if (current.children[c - 'a'] == null)
                current.children[c - 'a'] = new TrieNode(c);
            current = current.children[c - 'a'];
        }
        current.word = word;
    }

    public boolean search(String word) {
        Queue<TrieNode> q = new LinkedList();
        q.offer(root);
        for (char c: word.toCharArray()) {
            int size = q.size();
            while (size > 0) {
                TrieNode current = q.poll();
                if (c == '.') {
                    for (TrieNode n : current.children) {
                        if (n != null) q.offer(n);
                    }
                } else {
                    if (current.children[c - 'a'] != null)
                        q.offer(current.children[c - 'a']);
                }             
                size--;
            }
        }
        while (!q.isEmpty()) {
            TrieNode current = q.poll();
            if (current.word != null) return true;
        }
        return false;
    }
}


class TrieNode {
    char c;
    String word;
    TrieNode[] children = new TrieNode[26];
    public TrieNode(char c) {
        this.c = c;
    }
}