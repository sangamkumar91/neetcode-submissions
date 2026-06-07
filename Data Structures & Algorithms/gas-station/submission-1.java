class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        for (int i = 0 ; i < gas.length; i++) {
            gas[i] = gas[i] - cost[i];
            totalCost = totalCost + gas[i];
        }

        if (totalCost < 0) return -1;
        boolean flip = false;
        for (int i = 0 ; i < gas.length; i++) {
            if (gas[i] < 0) continue;
            int fuel = gas[i];
            int current = i;
            i++;
            if (i == gas.length) {
                flip = true;
                i = 0;
            }
            while (fuel >= 0) {
                if (i == current) return i;
                fuel = fuel + gas[i];
                i++;
                if (i == gas.length) {
                    flip = true;
                    i = 0;
                }
            }

            // We dont need to go back from i 
            // because if there was valid station
            // then fuel would never have hit negative. 

            // Decrement as i++ already happening in for loop
            i--;
            if (flip) break;
        }  

        return -1;     
        
    }
}
