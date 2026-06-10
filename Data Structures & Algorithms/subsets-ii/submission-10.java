class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(new ArrayList(), nums, 0);
        return res;
    }

    public void dfs(List<Integer> current, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList(current));
            return;
        }

        current.add(nums[index]);
        dfs(current, nums, index + 1);
        current.remove(current.size() - 1);

        // this helps avoid duplicates
        //nums = [1,1]
        // if not added
        // [1, *] include i = 0 -> [[1, 1] include i = 1 and [1, x] exclude i = 1]
        // [x, *] skip i = 0 -> [[x, 1] include i = 1 and [x, x] exclude i = 1]
        // But it creates same subset. [1,x] and [x, 1] i.e [1]

        // instead we do 
        // [1, *] include i = 0 -> [[1, 1] include i = 1]
        // [x, *] skip i = 0 -> [[x, 1] include i = 1 and [x, x] exclude i = 1]
        // either [1,x] or [x, 1]created only once.
        int i = index + 1;
        while (i < nums.length && nums[i] == nums[i - 1]) i++;
        dfs(current, nums, i);
    }


    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        List<Integer> list = new LinkedList();
        
        for (int i = 0 ; i < nums.length ; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
                list.add(nums[i]);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        
        List<List<Integer>> results = new LinkedList();
        results.add(new ArrayList());
        backtrack(map, list, results, 0);
        return results;
    }
    
    public void backtrack(HashMap<Integer, Integer> map, List<Integer> list, List<List<Integer>> results, int index) {
        
        if (index == list.size()) return;
                
        int node = list.get(index);
        int count = map.get(node);
        
        List<List<Integer>> prevLists = new ArrayList(results);
        while(count > 0){
            List<List<Integer>> currLists = new ArrayList();
            int currentsize = prevLists.size();
            for (int j = 0 ; j < currentsize; j++) {
                List<Integer> current = new ArrayList(prevLists.get(j));
                current.add(node);
                currLists.add(current);
            }
            results.addAll(currLists);
            prevLists = currLists;
            count--;
        }
        
        backtrack(map, list, results, index + 1);
    }
}