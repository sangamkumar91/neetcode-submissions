class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        for (int i = 0 ; i < gas.length; i++) {
            gas[i] = gas[i] - cost[i];
            totalCost = totalCost + gas[i];
        }

        if (totalCost < 0) return -1;
        System.out.println(totalCost);
        boolean flip = false;
        for (int i = 0 ; i < gas.length; i++) {
            System.out.println(i);
            if (gas[i] < 0) continue;
            System.out.println(i);
            int fuel = gas[i];
            int current = i;
            i++;
            if (i == gas.length) {
                flip = true;
                i = 0;
            }
            while (fuel >= 0) {
                System.out.println(fuel);
                System.out.println(i);
                if (i == current) return i;
                fuel = fuel + gas[i];
                i++;
                if (i == gas.length) {
                    flip = true;
                    i = 0;
                }
            }
            i--;
            if (flip) break;
        }  

        return -1;     
        
    }
}
