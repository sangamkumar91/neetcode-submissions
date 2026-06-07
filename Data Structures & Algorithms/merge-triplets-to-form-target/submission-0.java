class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        int start = 0 ;
        int end = 1;

        while (end < triplets.length) {
            if (!isValid(triplets[start], target)) {
                start = end;
                end = end + 1;
                continue;
            }
            if (!isValid(triplets[end], target)) {
                end = end + 1;
                continue;
            }
            triplets[end][0] = Math.max(triplets[start][0], triplets[end][0]);
            triplets[end][1] = Math.max(triplets[start][1], triplets[end][1]);
            triplets[end][2] = Math.max(triplets[start][2], triplets[end][2]);
            start = end;
            end = end + 1;
        }
        return triplets[start][0] == target[0] && triplets[start][1] == target[1] && triplets[start][2] == target[2];

    }
    public boolean isValid(int[] source, int[] target) {
        if (source[0] > target[0] || source[1] > target[1] || source[2] > target[2]) {
            return false;
        }
        return source[0] == target[0] || source[1] == target[1] || source[2] == target[2];
    }
}
