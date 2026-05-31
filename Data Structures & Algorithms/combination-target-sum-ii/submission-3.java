class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList();
        helper(candidates, result, new ArrayList(), target, 0);
        return result;
    }

    public void helper(
        int[] candidates,
        List<List<Integer>> result,
        List<Integer> current,
        int target,
        int index
    ) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList(current));
            return;
        }
        if (index == candidates.length) return;

        current.add(candidates[index]);
        helper(candidates, result, current, target - candidates[index], index + 1);
        current.remove(current.size() - 1);

        int next = index;
        while (next < candidates.length && candidates[next] == candidates[index]) {
            next++;
        }
        
        helper(candidates, result, current, target , next);
    }
}
