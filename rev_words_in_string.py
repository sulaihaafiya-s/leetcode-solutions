class Solution:
    def reverseWords(self, s: str) -> str:
        words = s.split()  # Split by whitespace and filter out extra spaces
        return ' '.join(reversed(words))  # Reverse the list and join with a single space

# Example usage
solution = Solution()
result1 = solution.reverseWords("the sky is blue")
result2 = solution.reverseWords("  hello world  ")
print(result1)  # Output: "blue is sky the"
print(result2)  # Output: "world hello"
