class Solution:
    def searchRange(self, nums: list, target: int) -> list:
        def findLeftIndex():
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return left

        def findRightIndex():
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] <= target:
                    left = mid + 1
                else:
                    right = mid - 1
            return right

        left_index = findLeftIndex()
        right_index = findRightIndex()

        if left_index <= right_index:
            return [left_index, right_index]
        return [-1, -1]

# Example usage
solution = Solution()
result1 = solution.searchRange([5, 7, 7, 8, 8, 10], 8)
result2 = solution.searchRange([5, 7, 7, 8, 8, 10], 6)
print(result1)  # Output: [3, 4]
print(result2)  # Output: [-1, -1]
