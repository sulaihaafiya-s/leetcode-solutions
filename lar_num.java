import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert integers to strings
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // Sort strings using custom comparator: (b + a) vs (a + b)
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if the largest number is "0", return "0"
        if (strs[0].equals("0")) {
            return "0";
        }

        // Join strings to form the final result
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }
}
