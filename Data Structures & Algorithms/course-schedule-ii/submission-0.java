class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] pre: prerequisites) {
            adj.putIfAbsent(pre[1], new ArrayList<Integer>());
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 0 ; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int completed = 0;
        List<Integer> result = new ArrayList();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int course = queue.poll();
                completed++;
                result.add(course);
                for (int j : adj.getOrDefault(course, new ArrayList<Integer>())) {
                    indegree[j]--;
                    if (indegree[j] == 0) {
                        queue.offer(j);
                    }
                }
                size--;
            }
        }
        if (completed != numCourses)
            return new int[0];

        int z = 0;
        for (int x : result) {
            indegree[z] = x;
            z++;
        }
        return indegree;
    }
}
