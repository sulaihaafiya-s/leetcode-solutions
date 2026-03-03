class Solution:
    def removeElement(self, nums: list, val: int) -> int:
        k = 0  # Initialize the count of elements not equal to val

        for i in range(len(nums)):
            if nums[i] != val:  # If the current element is not val
                nums[k] = nums[i]  # Move it to the front
                k += 1  # Increment the count

        return k

# Example usage
solution = Solution()
nums = [3, 2, 2, 3]
k = solution.removeElement(nums, 3)
print(k)         # Output: 2
print(nums[:k])  # Output: [2, 2]
