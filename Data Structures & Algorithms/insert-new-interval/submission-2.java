class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList();
        boolean added = false;
        for (int i = 0 ; i < intervals.length ; i++) {
            int[] current = intervals[i];
            if (!added) {
                if (current[1] < newInterval[0] && current[0] < newInterval[0]) {
                    result.add(current);
                    continue;
                }
                added = true;
                if (current[0] > newInterval[1] && current[0] > newInterval[1]) {
                    result.add(newInterval);
                    result.add(current);
                    continue;
                }
                while (i < intervals.length && !(current[0] > newInterval[1] && current[1] > newInterval[1])) {
                    newInterval[0] = Math.min(newInterval[0], current[0]);
                    newInterval[1] = Math.max(newInterval[1], current[1]);
                    i++;
                    if (i == intervals.length) break;
                    current = intervals[i];
                }
                result.add(newInterval);
                i--;
                continue;
            }
            result.add(current);
        }

        if (!added) {
            result.add(newInterval);
        }

        return  result.toArray(new int[0][]);      
    }
}
