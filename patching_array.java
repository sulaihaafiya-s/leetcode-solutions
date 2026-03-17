class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int patches = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // If the current number in the array can extend our range
                miss += nums[i];
                i++;
            } else {
                // We have a gap, so we "patch" the array by adding 'miss'
                miss += miss;
                patches++;
            }
        }

        return patches;
    }
}
