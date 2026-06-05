class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] time = new int[numCourses];
        int[] completed = new int[numCourses];
        List<List<Integer>> result = new ArrayList();
        HashMap<Integer, List<Integer>> adj = new HashMap();

        for (int[] edge: prerequisites) {
            adj.putIfAbsent(edge[1], new ArrayList());
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque();

        for (int i = 0 ; i < numCourses ; i++) {
            if (indegree[i] == 0) q.offerFirst(i);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> batch = new ArrayList();
            while (size > 0) {
                int p = q.pollLast();
                batch.add(p);
                completed[p] = completed[p] + time[p];
                for (int c : adj.getOrDefault(p, new ArrayList<Integer>())) {
                    indegree[c]--;
                    completed[c] = Math.max(completed[c], time[p]);
                    if (indegree[c] == 0)
                        q.offerFirst(c);
                }
                size--;
            }
            result.add(batch);
        }
        System.out.println(Arrays.toString(indegree));

        for (int i : indegree) {
            if (i != 0) return false;
        }

        return true;
    }
}
