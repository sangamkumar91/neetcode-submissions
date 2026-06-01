class Solution {
    public boolean checkValidString(String s) {
        int balance = 0;

        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                balance--;
                if (balance < 0) return false;
                continue;
            }
            balance++;
        }
        balance = 0;
        for (int i = s.length() - 1 ; i >= 0 ; i--) {
            System.out.println(balance);
            if (s.charAt(i) == '(') {
                balance--;
                if (balance < 0) return false;
                continue;
            }
            balance++;
        }

        return true;
    }
}
