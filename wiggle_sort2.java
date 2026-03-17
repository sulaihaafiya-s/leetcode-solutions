import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] copy = nums.clone();
        Arrays.sort(copy);
        
        // Use two pointers starting from the end of each half
        // left: end of the smaller half (indices 0 to (n-1)/2)
        // right: end of the larger half (indices (n-1)/2 + 1 to n-1)
        int left = (n - 1) / 2;
        int right = n - 1;
        
        for (int i = 0; i < n; i++) {
            // Even indices get elements from the smaller half
            if (i % 2 == 0) {
                nums[i] = copy[left--];
            } 
            // Odd indices get elements from the larger half
            else {
                nums[i] = copy[right--];
            }
        }
    }
}
