class Solution {
    public int reverse(int x) {
        int num = 0;
        while( x / 10 != 0 || x % 10 != 0) {
            if (num > 0 && num > Integer.MAX_VALUE / 10) return 0;
            if (num < 0 && num < Integer.MIN_VALUE / 10) return 0;
            if (num > 0 && num * 10 > Integer.MAX_VALUE - x % 10) return 0;
            if (num < 0 && num * 10 < Integer.MIN_VALUE - x % 10) return 0;
            num = num * 10 + x % 10;
            x = x / 10;
        }
        return num;
    }
}

//a * 10 + b % 10 < C
