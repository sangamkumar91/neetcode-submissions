class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        TreeSet<Integer> sortedSet = new TreeSet<>((a, b) -> {
            return map.get(b) != map.get(a) ? map.get(b) - map.get(a) : b - a;
        });

        for (int i = 0; i < nums.length ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        sortedSet.addAll(map.keySet());
        List<Integer> result = new ArrayList();
        for (Integer i : sortedSet) {
            result.add(i);
            k--;
            if (k == 0) break;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
