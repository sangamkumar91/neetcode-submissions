class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, Set<Character>> adj = new HashMap();
        HashSet<Character> explored = new HashSet();
        for (String word: words)
            for (char c: word.toCharArray())
                adj.put(c, new HashSet());
        
        for (int i = 0 ; i < words.length - 1; i++) {
            int j = 0;
            int range = Math.min(words[i].length(), words[i + 1].length());
            while (j < range && words[i].charAt(j) == words[i + 1].charAt(j)) {
                j++;
            }
            if (j < range) {
                adj.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
            }
            if (j == range && words[i].length() > words[i + 1].length()) {
                return "";
            }

        }

        HashSet<Character> visited = new HashSet();
        ArrayList<Character> result = new ArrayList();
        for (char c: adj.keySet()) {
            if (!dfs(explored, adj, visited, result, c)) {
                return "";
            }
        }
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }

    public boolean dfs(
        HashSet<Character> explored,
        HashMap<Character, Set<Character>> adj,
        HashSet<Character> visited,
        ArrayList<Character> result,
        Character c
    ) {
        if (visited.contains(c)) return false;
        if (explored.contains(c)) return true;
        visited.add(c);

        for (Character n : adj.getOrDefault(c, new HashSet<Character>())) {
            if (!dfs(explored, adj, visited, result, n)) {
                return false;
            }
        }
        result.add(c);
        explored.add(c);
        visited.remove(c);
        return true;
    }
}