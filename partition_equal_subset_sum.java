class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // 1. If total sum is odd, we can't split it into two equal integer halves
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        
        // 2. dp[i] will be true if a subset sum of 'i' is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: sum 0 is always possible with an empty subset

        // 3. Iterate through each number and update possible sums
        for (int num : nums) {
            // Iterate backwards to ensure we use each 'num' only once per subset
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
            
            // Optimization: if target is already achievable, exit early
            if (dp[target]) return true;
        }

        return dp[target];
    }
}
