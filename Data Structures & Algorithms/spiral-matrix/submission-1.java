class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> result = new ArrayList();

        while (top <= bottom && left <= right) {
            // left to right
            for (int i = left ; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            // top to bottom
            for (int i = top + 1; i < bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (top == bottom) break;
            //  right to left
            for (int i = right ; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            if (left == right) break;
            //  bottom to top
            for (int i = bottom - 1 ; i > top; i--) {
                result.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }

        return result;
    }
}
