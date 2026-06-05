class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();

        // Rectangles in the histogram on the left and right rectangeles of the index such that the whole i-th bar can be included.
        int[] leftLimit = new int[heights.length];
        int[] rightLimit = new int[heights.length];

        for (int i = 0; i < heights.length ; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty())
                leftLimit[i] = heights[i] * (i - stack.peek());
            else
                leftLimit[i] = heights[i] * (i + 1);
            stack.push(i);
        }
        stack.clear();
        for (int i = heights.length - 1; i >=0 ; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty())
                rightLimit[i] = heights[i] * (stack.peek() - i);
            else
                rightLimit[i] = heights[i] * (heights.length - i);
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            // as height[i] is added twice -> once in left and once in right
            maxArea = Math.max(maxArea, leftLimit[i] + rightLimit[i] - heights[i]);
        }
        return maxArea;

    }
    
    public int largestRectangleArea_O_N_Square(int[] heights) {

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
