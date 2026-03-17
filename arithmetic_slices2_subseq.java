import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int totalCount = 0;
        Map<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                int countAtJ = dp[j].getOrDefault(diff, 0);
                
                totalCount += countAtJ;
                
                int countAtI = dp[i].getOrDefault(diff, 0);
                dp[i].put(diff, countAtI + countAtJ + 1);
            }
        }

        return totalCount;
    }
}
