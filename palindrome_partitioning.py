class Solution:
    def partition(self, s: str) -> list:
        def is_palindrome(substring):
            return substring == substring[::-1]

        def backtrack(start, path):
            if start == len(s):
                result.append(path)
                return
            for end in range(start + 1, len(s) + 1):
                if is_palindrome(s[start:end]):
                    backtrack(end, path + [s[start:end]])

        result = []
        backtrack(0, [])
        return result

# Example usage
solution = Solution()
result1 = solution.partition("aab")
result2 = solution.partition("a")
print(result1)  # Output: [["a","a","b"],["aa","b"]]
print(result2)  # Output: [["a"]]
