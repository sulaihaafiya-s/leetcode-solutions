class Solution:
    def removeDuplicates(self, nums: list) -> int:
        if not nums:
            return 0
        
        k = 1  # Initialize the count of unique elements

        for i in range(1, len(nums)):
            if nums[i] != nums[k - 1]:  # Found a new unique element
                nums[k] = nums[i]  # Update the position of the unique element
                k += 1  # Increase the count of unique elements

        return k

# Example usage
solution = Solution()
nums = [1, 1, 2]
k = solution.removeDuplicates(nums)
print(k)       # Output: 2
print(nums[:k])  # Output: [1, 2]
