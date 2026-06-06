class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int start = 1;
        int end = piles[piles.length - 1];

        while (start < end) {
            int mid = start + (end - start)/2;
            int t = totalTime(piles, mid);
            if (t > h) {
                start = mid + 1;
                continue;
            }
            end = mid;
        }
        return start;
    }
    public int totalTime(int[] piles, int k) {
        int hrs = 0;

        for (int b: piles) {
            hrs = hrs + b/k;
            if (b%k != 0) hrs++;
        }
        return hrs;
    }
}
