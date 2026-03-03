class Solution:
    def threeSumClosest(self, nums: list, target: int) -> int:
        nums.sort()  # Sort the array
        closest_sum = float('inf')  # Initialize to a large value
        
        for i in range(len(nums) - 2):
            left, right = i + 1, len(nums) - 1
            
            while left < right:
                current_sum = nums[i] + nums[left] + nums[right]
                
                if abs(current_sum - target) < abs(closest_sum - target):
                    closest_sum = current_sum
                
                if current_sum < target:
                    left += 1
                elif current_sum > target:
                    right -= 1
                else:
                    return current_sum  # Exact match found
        
        return closest_sum

# Example usage
solution = Solution()
result1 = solution.threeSumClosest([-1, 2, 1, -4], 1)
result2 = solution.threeSumClosest([0, 0, 0], 1)
print(result1)  # Output: 2
print(result2)  # Output: 0
