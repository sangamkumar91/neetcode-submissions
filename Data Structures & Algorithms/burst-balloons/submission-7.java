class Solution {
    public int maxCoins(int[] nums) {
        // HashSet<Integer> visited = new HashSet();
        // HashMap<String, Integer> memo = new HashMap();
        // return backtrack(nums, visited, memo);
        int[] numsWithborder = new int[nums.length + 2];
        for (int i = 0 ; i < nums.length ; i++) {
            numsWithborder[i + 1] = nums[i];
        }
        numsWithborder[0] = 1;
        numsWithborder[numsWithborder.length - 1] = 1;
        System.out.println(Arrays.toString(numsWithborder));
        int[][] memo = new int[numsWithborder.length][numsWithborder.length];
        return dp(numsWithborder, 0, numsWithborder.length - 1, memo);
    }


    // On^3 0> because total (left, right) pairs for an array = n * (n-1)/2.
    // And For each left right pair we are looping n
    public int dp(int[] nums, int left, int right, int[][] memo) {
        if (right == 0) {
            return 0;
        }
        if (left == nums.length - 1) {
            return 0;
        }
        if (left == right) {
            return 0;
        }
        if (memo[left][right] != 0) return memo[left][right];
        int result = 0;
        for (int i = left + 1 ; i < right ; i++) {
            // Assume last burst with only i, left and right remaining
            int product = nums[left] * nums[right] * nums[i];
            result = Math.max(
                result,
                // Last burst
                product + 
                // Max coin for the burst in the subaarays
                dp(nums, left , i, memo) + 
                dp(nums, i, right, memo)
            );
        }
        memo[left][right] = result;
        return result;
    }












    public int backtrack(int[] nums, HashSet<Integer> visited, HashMap<String, Integer> memo) {
        int result = 0;
        if (visited.size() == nums.length) {
            return result;
        }
        String key = hashKey(nums, visited);
        if (memo.containsKey(key)) return memo.get(key);
        for (int i = 0 ; i < nums.length ; i++) {
            if (visited.contains(i)) continue;
            visited.add(i);
            int product = coinsPerBurst(nums, visited, i);
            result = Math.max(result, coinsPerBurst(nums, visited, i) + backtrack(nums, visited, memo));
            visited.remove(i);
        }
        memo.put(key, result);
        return result;
    }

    public int coinsPerBurst(int[] nums, HashSet<Integer> visited, int i) {
            int product = nums[i];
            int j = i - 1;
            while (j >= 0 && visited.contains(j)) {
                j--;
            }
            product = product * (j >= 0 ? nums[j] : 1);
            j = i + 1;
            while (j < nums.length && visited.contains(j)) {
                j++;
            }
            product = product * (j < nums.length ? nums[j] : 1);
            return product;
    }

    public String hashKey(int[] nums, HashSet<Integer> visited) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < nums.length ; i++) {
            if (visited.contains(i)) continue;
            sb.append(nums[i]);
            sb.append(",");
        }
        return sb.toString();
    }

}
