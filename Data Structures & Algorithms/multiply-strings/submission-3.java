class Solution {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        List<Integer> result = new ArrayList();
        int power = 0;
        for (int i = num1.length() - 1 ; i >= 0 ; i--) {
            int n1 = num1.charAt(i) - '0';
            int start = power;
            int carry = 0;
            for (int j = num2.length() - 1 ; j >= 0 ; j--) {
                int n2 = num2.charAt(j) - '0';
                int p = n1 * n2 + carry;
                if (start < result.size()) {
                    p = p + result.get(start);
                }
                int r = p % 10;
                carry = p / 10;
                if (start < result.size()) {
                    result.set(start, r);
                } else {
                    result.add(r);
                }                
                start++;
            }
            if (carry != 0)
                result.add(carry);
            power++;
        }
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        result.stream().forEach((x) -> sb.append(x));

        return sb.toString();

    }
}
