public class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length > 0) {
                break;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));        // Output: 5
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  ")); // Output: 4
        System.out.println(solution.lengthOfLastWord(""));                  // Output: 0
        System.out.println(solution.lengthOfLastWord("a"));                 // Output: 1
        System.out.println(solution.lengthOfLastWord("   "));               // Output: 0
    }
}
