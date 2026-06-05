class TrieNode{
    char c;
    String word;
    HashMap<Character, TrieNode> children = new HashMap();
    public TrieNode(char c) {
        this.c = c;
    }
}
class Solution {
    int m;
    int n;
    int[][] directions = new int[][] {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };
    TrieNode root = new TrieNode('.');

    // Compexity is m * n * 4 ^ (maxWordLength)
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        Set<String> result = new HashSet();
        for (String word: words) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode(c));
                current = current.children.get(c);
            }
            current.word = word;
        }
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                dfsTrie(board, root, i, j, result);
            }
        }
        return new ArrayList(result);   
    }
    public void dfsTrie(char[][] board, TrieNode node, int i, int j, Set<String> result) {
        if (i < 0 || j < 0 || j == n || i == m) return;
        char c = board[i][j];
        if (!node.children.containsKey(c)) return;
        TrieNode next = node.children.get(c);
        if (next.word != null) result.add(next.word);
        board[i][j] = '*';
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            dfsTrie(board, next, x, y, result);
        }
        board[i][j] = c;
    }


    // Compexity is w * m * n * 4 ^ (maxWordLength)
    public List<String> findWordsBruteForce(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        Set<String> result = new HashSet();
        for (String word: words) {
            for(int i = 0 ; i < m ; i++) {
                if (result.contains(word)) break;
                for(int j = 0 ; j < n ; j++) {
                    if (result.contains(word)) break;
                    if (board[i][j] != word.charAt(0)) continue;
                    boolean[][] visited = new boolean[m][n];
                    if (dfs(board, word, visited, i, j, 0)){
                        result.add(word);
                    }
                }
            }
        }
        return new ArrayList(result);   
    }

    public boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || j == n || i == m) return false;
        if (visited[i][j]) return false;
        if (board[i][j] != word.charAt(index)) return false;
        visited[i][j] = true;
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            if (dfs(board, word, visited, x, y, index + 1)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}
