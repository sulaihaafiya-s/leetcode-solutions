class Solution:
    def numDecodings(self, s: str) -> int:
        if not s or s[0] == '0':
            return 0

        n = len(s)
        dp = [0] * (n + 1)
        dp[0] = 1  # Base case: one way to decode an empty string
        dp[1] = 1  # One way to decode a string of length 1 if it's not '0'

        for i in range(2, n + 1):
            # Check last one digit
            if s[i - 1] != '0':
                dp[i] += dp[i - 1]
            # Check last two digits
            if 10 <= int(s[i - 2:i]) <= 26:
                dp[i] += dp[i - 2]

        return dp[n]

# Example usage
solution = Solution()
result = solution.numDecodings("11106")
print(result)  # Output: 2
