class Solution {
    int n;
    public void rotate(int[][] matrix) {
        n = matrix.length;
        mirrorHorizontal(matrix);
        transponseAcrossPositiveDiagnol(matrix);
        
    }
    public void transponseAcrossPositiveDiagnol(int[][] matrix) {
        for (int i = 0 ; i < n; i++) {
            for (int j = i ; j < n; j++)
                swap(matrix, i, j, j, i);
        }
    }
    public void mirrorHorizontal(int[][] matrix) {
        for (int i = 0 ; i < n/2; i++) {
            for (int j = 0 ; j < n; j++)
                swap(matrix, i, j, n - 1 - i, j);
        }
    }
    public void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

}
