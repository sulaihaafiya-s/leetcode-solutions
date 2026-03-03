class Solution:
    def minCut(self, s: str) -> int:
        n = len(s)
        if n == 0:
            return 0
        
        # Create a 2D array to store palindrome information
        is_palindrome = [[False] * n for _ in range(n)]
        
        # Fill the palindrome table
        for i in range(n):
            is_palindrome[i][i] = True  # Single character is always a palindrome
        for length in range(2, n + 1):
            for start in range(n - length + 1):
                end = start + length - 1
                if s[start] == s[end]:
                    if length == 2 or is_palindrome[start + 1][end - 1]:
                        is_palindrome[start][end] = True

        # Create an array to store minimum cuts
        cuts = [float('inf')] * n
        for i in range(n):
            if is_palindrome[0][i]:
                cuts[i] = 0  # No cuts needed if the whole substring is a palindrome
            else:
                for j in range(i):
                    if is_palindrome[j + 1][i]:
                        cuts[i] = min(cuts[i], cuts[j] + 1)

        return cuts[-1]

# Example usage
solution = Solution()
result1 = solution.minCut("aab")
result2 = solution.minCut("a")
result3 = solution.minCut("ab")
print(result1)  # Output: 1
print(result2)  # Output: 0
print(result3)  # Output: 1
