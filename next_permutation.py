class Solution:
    def nextPermutation(self, nums: list) -> None:
        i = len(nums) - 2
        while i >= 0 and nums[i] >= nums[i + 1]:
            i -= 1
        
        if i >= 0:
            j = len(nums) - 1
            while nums[j] <= nums[i]:
                j -= 1
            nums[i], nums[j] = nums[j], nums[i]
        
        nums[i + 1:] = reversed(nums[i + 1:])

# Example usage
solution = Solution()
nums1 = [1, 2, 3]
solution.nextPermutation(nums1)
print(nums1)  # Output: [1, 3, 2]

nums2 = [3, 2, 1]
solution.nextPermutation(nums2)
print(nums2)  # Output: [1, 2, 3]
