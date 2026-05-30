class Solution {
    // Space (o log n)
    public boolean isHappySlow(int n) {
        HashSet<Integer> seen = new HashSet();
        seen.add(n);
        while (n != 1) {
            n = sumOfSquares(n);
            if (seen.contains(n))
                return false;
            seen.add(n);
        }

        return true;
        
    }
    // Space (o 1)
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquares(n);
        while (fast != slow) {
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);
            slow = sumOfSquares(slow);
        }

        return fast == 1;
        
    }

    public int sumOfSquares(int n) {
        int sum = 0;
        while (n != 0) {
            int r = n%10;
            sum = sum + (int)Math.pow(r, 2);
            n = n/10;
        }
        return sum;
    }
}
