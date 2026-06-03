class CountSquares {
    HashMap<String, Integer> map = new HashMap();
    public CountSquares() {
        
    }
    
    public void add(int[] point) {
        String key = getKey(point[0], point[1]);
        map.put(key, map.getOrDefault(key, 0) + 1);

        System.out.println(map.toString());
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        String key1 = getKey(x1, y1);
        int result = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key2 = entry.getKey();
            Integer count = entry.getValue();
            if (key2.equals(key1)) continue;
            int[] p = getXY(key2);
            int x2 = p[0];
            int y2 = p[1];

            if (Math.abs(x1 - x2) != Math.abs(y1 - y2)) continue;

            if (!map.containsKey(getKey(x1, y2)) || !map.containsKey(getKey(x2, y1))) continue;
            
            result = result + count * map.get(getKey(x1, y2)) * map.get(getKey(x2, y1));
        }
        return result;
    }

    public int[] getXY(String key) {
        String[] xy = key.split(",");
        int[] point = new int[2];
        point[0] = Integer.parseInt(xy[0]);
        point[1] = Integer.parseInt(xy[1]);
        return point;
    }
    public String getKey(int x, int y) {
        return x + "," + y;
    }

}
