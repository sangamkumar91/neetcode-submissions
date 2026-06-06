class Solution {
    int m;
    int n;
    public void setZeroes(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        for (int i = 0 ; i < m ; i++)
        for (int j = 0 ; j < n ; j++) {
            if (matrix[i][j] == 0) {
                updateRow(matrix, i);
                updateCol(matrix, j);
            }
        }
        for (int i = 0 ; i < m ; i++)
        for (int j = 0 ; j < n ; j++) {
            if (matrix[i][j] == -1) {
                matrix[i][j] = 0;
            }
        }
    }
    public void updateRow(int[][] matrix, int i) {
        for (int j = 0 ; j < n ; j++) {
            if (matrix[i][j] != 0) matrix[i][j] = -1;
        }
    }
    public void updateCol(int[][] matrix, int j) {
        for (int i = 0 ; i < m ; i++) {
            if (matrix[i][j] != 0) matrix[i][j] = -1;
        }        
    }

}
