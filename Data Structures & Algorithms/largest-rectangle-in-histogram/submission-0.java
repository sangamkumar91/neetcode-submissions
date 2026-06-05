class Solution {
    public int largestRectangleArea(int[] heights) {

        TreeSet<Integer> sortedSet = new TreeSet();
        for (int h : heights)
            sortedSet.add(h);

        int maxRectangle = 0;

        for (int n: sortedSet) {
            int currentRectangle = 0;
            for (int i = 0 ; i < heights.length; i++) {
                if (heights[i] >= n) {
                    currentRectangle = currentRectangle + n;
                    continue;
                }
                maxRectangle = Math.max(maxRectangle, currentRectangle);
                currentRectangle = 0;                
            }
            maxRectangle = Math.max(maxRectangle, currentRectangle);
            currentRectangle = 0;                
        }
        return maxRectangle;
    }
}
