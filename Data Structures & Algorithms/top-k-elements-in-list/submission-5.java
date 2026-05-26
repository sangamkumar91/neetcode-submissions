class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return map.get(a) != map.get(b) ? map.get(a) - map.get(b) : a - b;
        });

        for (int i = 0; i < nums.length ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer i : map.keySet()) {
            pq.offer(i);
            if (pq.size() > k) pq.poll();
        }
        return pq.stream().mapToInt(Integer::intValue).toArray();
    }
}
