class Solution {
    int m;
    int n;
    int[][] directions = new int[][] {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    public List<String> findWords(char[][] board, String[] words) {
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
