class Solution {
    public List<String> generateParenthesis(int n) {
        return new ArrayList(backtrack(n));
    }
    public Set<String> backtrack(int n) {
        if (n == 1) {
            Set<String> s = new HashSet();
            s.add("()");
            return s;
        }
        HashSet<String> result = new HashSet();


        // This is incorrect because (())(()) ->this gets missed
        // for (String s: backtrack(n - 1)) {
        //     result.add("()" + s);
        //     result.add("(" + s + ")");
        //     result.add(s + "()");
        // }
        for (String s: backtrack(n - 1)) {
            for (int i = 0 ; i < s.length() ; i++) {
                result.add(s.substring(0, i) + "()" + s.substring(i));
            }
        }
        return result;
    }
}
