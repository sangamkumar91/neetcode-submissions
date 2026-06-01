class TimeMap {
    HashMap<String, TreeMap<Integer, String>> store = new HashMap();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new TreeMap());
        store.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> history = store.getOrDefault(key, null);
        if (history == null || history.isEmpty()) return "";
        Integer floor = history.floorKey(timestamp);
        if (floor == null) return "";
        return history.get(floor);
        
    }
}
