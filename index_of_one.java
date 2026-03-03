public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        for (int i = 0; i <= haystackLen - needleLen; i++) {
            if (haystack.substring(i, i + needleLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello", "ll")); // Output: 2
        System.out.println(solution.strStr("aaaaa", "bba")); // Output: -1
        System.out.println(solution.strStr("", ""));         // Output: 0
        System.out.println(solution.strStr("abc", "c"));     // Output: 2
        System.out.println(solution.strStr("mississippi", "issip")); // Output: 4
    }
}
