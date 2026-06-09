class Solution {
    int N = 0;
    public List<String> generateParenthesis(int n) {
        N = n;
        List<String> result = new ArrayList();
        backtrack(new StringBuilder(), result, 0, 0);
        return result;
        // return new ArrayList(backtrack(n));
    }
    
    // Best approach
    public void backtrack(StringBuilder sb , List<String> result, int open, int close) {
        if (sb.length() == 2 * N) {
            result.add(sb.toString());
            return;
        }

        if (open < N) {
            sb.append("(");
            backtrack(sb, result, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(sb, result, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
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
