class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            map.put(n, null);
        }
        for (int n : nums) {
            parent(map, n);
        }
        HashMap<Integer, List<Integer>> unionMap = new HashMap();
        int result = 0;
        for (int n : map.keySet()) {
            List<Integer> union = unionMap.getOrDefault(map.get(n), new ArrayList());
            union.add(n);
            unionMap.put(map.get(n), union);
            result = Math.max(result, union.size());
        }
        return result;
    }

    public Integer parent(
        HashMap<Integer, Integer> map,
        int x) {
        if (!map.containsKey(x)) return null;
        if (map.get(x) != null) return map.get(x);
        Integer p = parent(map, x-1);
        if (p == null) p = x;
        // This is important to update parent of every visited node in single iteration,
        // otherwise the time complexity with be On^2
        map.put(x, p);
        return p;
    }
    public int longestConsecutiveHashMap(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>(); // value -> length of its sequence
        int maxLen = 0;

        for (int num : nums) {
            if (map.containsKey(num)) continue; // skip duplicates

            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            // Add ing this total sum because, this current number was not added to the sequence, so left and right were sperate sequences. 
            // After this number , it is one single sequence.
            int sum = left + right + 1;

            // mark the current number with the length of sequence it belongs to.
            map.put(num, sum);

            // mark the left and right number also with the new length of sequence they belong to.
            map.put(num - left, sum);
            map.put(num + right, sum);

            // It doesnt matter if we do not update all the numbers in the sequence but only the immediate left anf right because, this code will only be executed only if the current number if the gap in the sequence. Check the below example.

            maxLen = Math.max(maxLen, sum);
        }

        return maxLen;
    }
}
