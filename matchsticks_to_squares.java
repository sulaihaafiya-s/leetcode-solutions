import java.util.Arrays;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int m : matchsticks) sum += m;
        if (sum == 0 || sum % 4 != 0) return false;

        int target = sum / 4;
        Arrays.sort(matchsticks);
        
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        return dfs(matchsticks, new int[4], 0, target);
    }

    private boolean dfs(int[] sticks, int[] sides, int index, int target) {
        if (index == sticks.length) return true;

        for (int i = 0; i < 4; i++) {
            if (sides[i] + sticks[index] > target) continue;
            
            int j = i - 1;
            while (j >= 0) {
                if (sides[i] == sides[j]) break;
                j--;
            }
            if (j != -1) continue;

            sides[i] += sticks[index];
            if (dfs(sticks, sides, index + 1, target)) return true;
            sides[i] -= sticks[index];
        }
        return false;
    }
}
