class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int result;

        for (int i = 0; i < tokens.length; i++) {
            if (
                !tokens[i].equals("-")
                && !tokens[i].equals("+")
                && !tokens[i].equals("*")
                && !tokens[i].equals("/")
            ) {
                stack.push(Integer.valueOf(tokens[i]));
                continue;
            }

            int i2 = stack.pop();
            int i1 = stack.pop();


            if (tokens[i].equals("-")) {
                i1 = i1 - i2;
            }
            if (tokens[i].equals("+")) {
                i1 = i1 + i2;
            }
            if (tokens[i].equals("*")) {
                i1 = i1 * i2;
            }
            if (tokens[i].equals("/")) {
                i1 = i1 / i2;
            }
            stack.push(i1);
        }
        return stack.pop();
    }
}
