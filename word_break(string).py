class Solution:
    def wordBreak(self, s: str, wordDict: list) -> bool:
        wordSet = set(wordDict)  # Convert list to set for O(1) lookups
        dp = [False] * (len(s) + 1)
        dp[0] = True  # Base case: empty string can always be segmented

        for i in range(1, len(s) + 1):
            for j in range(i):
                if dp[j] and s[j:i] in wordSet:
                    dp[i] = True
                    break

        return dp[len(s)]

# Example usage
solution = Solution()
result1 = solution.wordBreak("leetcode", ["leet", "code"])
result2 = solution.wordBreak("applepenapple", ["apple", "pen"])
print(result1)  # Output: True
print(result2)  # Output: True
