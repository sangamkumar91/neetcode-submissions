class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        PriorityQueue<int[]> cars = new PriorityQueue<>((a , b) -> {
            return b[0] - a[0];
        });
        int fleet = 0;
        for (int i = 0; i < position.length ; i++) {
            cars.offer( new int[] {position[i], speed[i]});
        }
        double prevT = -1.0;
        while (!cars.isEmpty()) {
            double t = (target - cars.peek()[0])/ (double)cars.peek()[1];
            if (t > prevT) {
                prevT = t;
                fleet++;
            }
            cars.poll();
        }

        return fleet;
        
    }
}
