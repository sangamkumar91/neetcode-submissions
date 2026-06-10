class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int start = 0;
        int end = points.length - 1;
        while (start < end) {
            System.out.println(Arrays.toString(points));
            int p = partition(points, start, end);
            System.out.println(Arrays.toString(points));
            if (p == k)
                break;
            if (p > k) {
                end = p - 1;
                continue;
            }
            start = p + 1;
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    public int partition(int[][] points, int start, int end) {
        int pivot = end;
        double p = distance(points[pivot][0], points[pivot][1]);
        end = end - 1;
        while (start <= end) {
            double s = distance(points[start][0], points[start][1]);
            if (s <= p) {
                start++;
                continue;
            }
            swap(points, start, end);
            end--;
        }
        swap(points, start, pivot);
        return start;
    }

    public double distance(int x1, int y1) {
        return Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
    }
    public void swap(int[][] points, int i , int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

}
