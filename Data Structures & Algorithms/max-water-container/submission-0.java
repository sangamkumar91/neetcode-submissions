class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int h1 = heights[left];
            int h2 = heights[right];
            result = Math.max(
                result,
                Math.min(h1, h2) * (right - left)
            );
            if (h1 < h2) {
                left++;
            } else {
                right--;
            }
        }
        return result;
        
    }
}
