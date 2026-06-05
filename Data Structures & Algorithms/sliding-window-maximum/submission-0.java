class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });
        List<Integer> result = new ArrayList();
        int index = 0;
        for (int i = 0; i < k - 1; i++) {
            pq.offer(new int[] {
                nums[i], i
            });
            index++;
        }
        for (int i = index; i < nums.length; i++) {
            pq.offer(new int[] {nums[i], i});
            while(pq.peek()[1] < i - k + 1) {
                pq.poll();
            }
            result.add(pq.peek()[0]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
