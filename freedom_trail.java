import java.util.*;

class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        List<Integer>[] positions = new List[26];
        for (int i = 0; i < 26; i++) positions[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) positions[ring.charAt(i) - 'a'].add(i);

        int[][] dp = new int[m + 1][n];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                for (int next : positions[key.charAt(i) - 'a']) {
                    int dist = Math.abs(j - next);
                    int step = Math.min(dist, n - dist);
                    dp[i + 1][next] = Math.min(dp[i + 1][next], dp[i][j] + step + 1);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) res = Math.min(res, dp[m][i]);
        return res;
    }
}
