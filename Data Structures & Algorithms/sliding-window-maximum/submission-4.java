class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> pq = new ArrayDeque<>();
        List<Integer> result = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            while (!pq.isEmpty() && pq.peekLast() < i - k + 1) {
                pq.pollLast();
            }
            while(!pq.isEmpty() && nums[pq.peekFirst()] < nums[i]) {
                pq.pollFirst();
            }
            pq.offerFirst(i);
            if (i < k - 1) continue;
            result.add(nums[pq.peekLast()]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    
    public int[] maxSlidingWindow_n_log_k(int[] nums, int k) {
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
