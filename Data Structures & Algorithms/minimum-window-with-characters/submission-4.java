class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> counter = new HashMap();
        int start = 0;
        int end = 0;
        for (char c: t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        };
        String result = "";
        while (end < s.length()) {
            char c = s.charAt(end);
            if (!counter.containsKey(c)) {
                end++;
                continue;
            }
            counter.put(c, counter.get(c) - 1);
            end++;
            while (start < end && counter.getOrDefault(s.charAt(start), -1) < 0) {
                if (counter.containsKey(s.charAt(start))) {
                    counter.put(s.charAt(start), counter.get(s.charAt(start)) + 1);
                }
                start++;
            }
            result = eval(s, start, end, counter, result);
        }
        return result;
    }
    public String eval(String s, int start, int end, HashMap<Character, Integer> counter, String result) {
        for (int c : counter.values()) {
            if (c > 0) return result;
        }
        String subs = s.substring(start, end);
        return subs.length() < result.length() || result.length() == 0 ? subs: result;
    } 
}
