class Solution:
    def fourSum(self, nums: list, target: int) -> list:
        nums.sort()  # Sort the array first
        quadruplets = []
        n = len(nums)

        for i in range(n - 3):
            # Skip duplicates for the first number
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            for j in range(i + 1, n - 2):
                # Skip duplicates for the second number
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
                left, right = j + 1, n - 1
                while left < right:
                    current_sum = nums[i] + nums[j] + nums[left] + nums[right]
                    if current_sum == target:
                        quadruplets.append([nums[i], nums[j], nums[left], nums[right]])
                        while left < right and nums[left] == nums[left + 1]:
                            left += 1  # Skip duplicates for the third number
                        while left < right and nums[right] == nums[right - 1]:
                            right -= 1  # Skip duplicates for the fourth number
                        left += 1
                        right -= 1
                    elif current_sum < target:
                        left += 1
                    else:
                        right -= 1

        return quadruplets

# Example usage
solution = Solution()
result1 = solution.fourSum([1, 0, -1, 0, -2, 2], 0)
result2 = solution.fourSum([2, 2, 2, 2, 2], 8)
print(result1)  # Output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
print(result2)  # Output: [[2, 2, 2, 2]]
