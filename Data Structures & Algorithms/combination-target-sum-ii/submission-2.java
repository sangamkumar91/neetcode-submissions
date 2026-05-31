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
        int duplicate = 0;
        int next = index;
        while (next < candidates.length && candidates[next] == candidates[index]) {
            next++;
            duplicate++;
        }
        for (int j = 0; j < duplicate; j++) {
            current.add(candidates[index]);
            helper(candidates, result, current, target - candidates[index] * (j + 1), next);
        }
        for (int j = 0; j < duplicate; j++)
            current.remove(current.size() - 1);
        
        helper(candidates, result, current, target , next);
    }
}
