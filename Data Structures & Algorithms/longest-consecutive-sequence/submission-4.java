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
}
