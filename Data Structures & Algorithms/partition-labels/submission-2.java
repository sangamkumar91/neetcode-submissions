class Solution {

    public List<Integer> partitionLabels(String s) {

        HashMap<Character, Integer> lastIndex = new HashMap();

        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            lastIndex.put(c, i);
        }
        // Keep exapnding the window based on last index till `i` passes window end.
        List<Integer> result = new ArrayList();
        int windowEnd = 0;
        int windowStart = 0;
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            int currentEnd = lastIndex.get(c);
            windowEnd = Math.max(currentEnd, windowEnd);
            if (i == windowEnd) {
                result.add(windowEnd - windowStart + 1);
                windowEnd = 0;
                windowStart = i + 1;
            }
        }

        
        return result;
    }

    // Using Intervals
    public List<Integer> partitionLabels_MERGE_INTERVALS(String s) {

        HashMap<Character, int[]> intervals = new HashMap();

        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            intervals.putIfAbsent(c, new int[] {i , i});
            int[] interval = intervals.get(c);
            interval[1] = i;
        }

        TreeSet<int[]> allIntervals = new TreeSet<>((a,b) -> {
            return a[0] - b[0];
        });
        allIntervals.addAll(intervals.values());
        List<int[]> result = new ArrayList();


        for (int[] i: allIntervals) {
            if (result.isEmpty()) {
                result.add(i);
                continue;
            }
            int size = result.size() - 1;
            if (i[0] > result.get(size)[1]) {
                result.add(i);
                continue;
            }
            result.get(size)[1] = Math.max(result.get(size)[1], i[1]);
        }
        
        return result.stream().map((a) -> a[1] - a[0] + 1).collect(Collectors.toList());
        
    }
}
