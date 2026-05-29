class Solution {
    public int trap(int[] height) {

        int curr = 0;
        int total = 0;
        int max = 0;
        int maxHeight = 0;
        int maxHeightIndex = -1;

        // Left Valley
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            maxHeight = Math.max(h, maxHeight);
            if (h < max) {
                curr = curr + (max - h);
                continue;
            }
            total = total + curr;
            curr = 0;
            max = h;
        }

        // Right Valley
        curr = 0;
        max = 0;
        for (int i = height.length - 1; i >=0; i--) {
            int h = height[i];
            if (h < max) {
                curr = curr + (max - h);
                continue;
            }
            total = total + curr;
            curr = 0;
            max = h;
            if (h == maxHeight) {
                maxHeightIndex = i;
                break;
            }
        }
        return total;
    }
}
