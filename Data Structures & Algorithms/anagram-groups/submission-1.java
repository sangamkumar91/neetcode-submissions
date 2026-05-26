class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            int[] chars = new int[26];
            for (char c: arr) {
                chars[c - 'a']++;
            }
            String key = Arrays.toString(chars);
            List list = map.getOrDefault(key, new ArrayList());
            list.add(s);
            map.put(key, list);
        }

        return new ArrayList(map.values());
    }
}
