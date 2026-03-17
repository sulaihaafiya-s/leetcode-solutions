class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Initialize the first and second smallest values to infinity
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= first) {
                // Found a new smallest value
                first = n;
            } else if (n <= second) {
                // Found a value larger than 'first' but smaller than 'second'
                second = n;
            } else {
                // Found a value larger than both 'first' and 'second'
                // This completes the triplet!
                return true;
            }
        }

        return false;
    }
}
