class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> map = new HashMap();
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            pq.offer(i);
        }
        int currentMin = pq.peek();
        while (!pq.isEmpty()) {
            for (int i = 0 ; i < groupSize ; i++) {
                int num = currentMin + i;
                if (map.getOrDefault(num, 0) == 0) return false;
                map.put(num, map.getOrDefault(num, 0) - 1);
            }

            while (!pq.isEmpty() && map.getOrDefault(pq.peek(), 0) == 0) {
                pq.poll();
            }
            if (pq.isEmpty()) break;
            currentMin = pq.peek();
        }

        return true;


    }
}
