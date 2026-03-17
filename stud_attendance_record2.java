class Solution {
    public int checkRecord(int n) {
        long MOD = 1_000_000_007;
        long[][][] dp = new long[n + 1][2][3];
        dp[0][0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == 0) continue;

                    // Add 'P' (Present)
                    dp[i + 1][j][0] = (dp[i + 1][j][0] + dp[i][j][k]) % MOD;

                    // Add 'A' (Absent)
                    if (j < 1) {
                        dp[i + 1][j + 1][0] = (dp[i + 1][j + 1][0] + dp[i][j][k]) % MOD;
                    }

                    // Add 'L' (Late)
                    if (k < 2) {
                        dp[i + 1][j][k + 1] = (dp[i + 1][j][k + 1] + dp[i][j][k]) % MOD;
                    }
                }
            }
        }

        long result = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                result = (result + dp[n][j][k]) % MOD;
            }
        }

        return (int) result;
    }
}
