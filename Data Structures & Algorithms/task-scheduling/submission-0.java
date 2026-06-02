class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b)-> {
            return map.get(b) - map.get(a);
        });

        for (char c: map.keySet()) {
            pq.offer(c);
        }
        int time = 0;
        while (!pq.isEmpty()) {
            Set<Character> executed = new HashSet();
            for (int i = 0 ; i <= n; i++) {
                time++;
                if (pq.isEmpty()) continue;
                char c = pq.poll();
                map.put(c, map.get(c) - 1);
                if (map.get(c) != 0) {
                    executed.add(c);
                } else {
                    map.remove(c);
                }
                if (map.isEmpty()) break;    
            }
            for (char c : executed) {
                pq.offer(c);
            }
        }
        return time;
        
    }
}
