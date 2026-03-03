class Solution:
    def isPalindrome(self, s: str) -> bool:
        filtered_chars = [char.lower() for char in s if char.isalnum()]
        return filtered_chars == filtered_chars[::-1]

# Example usage
solution = Solution()
result1 = solution.isPalindrome("A man, a plan, a canal: Panama")
result2 = solution.isPalindrome("race a car")
print(result1)  # Output: True
print(result2)  # Output: False
