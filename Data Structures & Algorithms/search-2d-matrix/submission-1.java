class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end =  m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int x = mid / n;
            int y = mid % n;
            int num = matrix[x][y];
            if (num == target) return true;
            if (num > target) {
                end = mid - 1;
                continue;
            }
            start = mid + 1;
        }

        return false;
    }
}
