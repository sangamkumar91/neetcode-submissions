class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, HashSet<String>> adj = new HashMap<String, HashSet<String>>();

        if (!wordList.contains(endWord)) {
            return 0;
        }

        createAdjacencyMatrixForWord(adj, wordList, beginWord);
        HashMap<String, Integer> visitedBegin = new HashMap();
        HashMap<String, Integer> visitedEnd = new HashMap();
        ArrayDeque<String> qBegin = new ArrayDeque();
        ArrayDeque<String> qEnd = new ArrayDeque();
        qBegin.offerFirst(beginWord);
        qEnd.offerFirst(endWord);
        visitedBegin.put(beginWord, 0);
        visitedEnd.put(endWord, 0);
        int dist = 1;

        while (!qBegin.isEmpty() || !qEnd.isEmpty()) {
            int size = qBegin.size();
            for (int i = 0 ; i < size; i++) {
                String head = qBegin.pollLast();
                if (visitedEnd.containsKey(head)) {
                    return visitedEnd.get(head) + visitedBegin.get(head) + 1;
                }
                for (String child : adj.getOrDefault(head, new HashSet<String>())) {
                    if (visitedBegin.containsKey(child)) continue;
                    qBegin.offerFirst(child);
                    visitedBegin.put(child, dist);
                }
            }
            size = qEnd.size();
            for (int i = 0 ; i < size; i++) {
                String head = qEnd.pollLast();
                if (visitedBegin.containsKey(head)) {
                    return visitedEnd.get(head) + visitedBegin.get(head) + 1;
                }
                for (String child : adj.getOrDefault(head, new HashSet<String>())) {
                    if (visitedEnd.containsKey(child)) continue;
                    qEnd.offerFirst(child);
                    visitedEnd.put(child, dist);
                }
            }
            dist++;
        }

        return 0;

    }

    public void createAdjacencyMatrixForWord(HashMap<String, HashSet<String>> adj, List<String> wordList,String beginWord) {
        for (String word : wordList) {
            adj.putIfAbsent(beginWord, new HashSet<String>());
            if (!isOneCharApart(beginWord, word)) continue;
            adj.get(beginWord).add(word);
        }
        for (int i = 0; i < wordList.size() ; i++) {
            String word1 = wordList.get(i);
            for (int j = i; j < wordList.size() ; j++) {
                String word2 = wordList.get(j);
                if (!isOneCharApart(word2, word1)) continue;
                adj.putIfAbsent(word1, new HashSet<String>());
                adj.putIfAbsent(word2, new HashSet<String>());
                adj.get(word1).add(word2);
                adj.get(word2).add(word1);
            }
        }
    }
    public boolean isOneCharApart(String s1, String s2) {
        int x = 0;
        for (int i = 0 ; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            x++;
        }
        return x == 1;
    }
}
