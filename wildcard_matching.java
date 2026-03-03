public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int sIndex = 0, pIndex = 0;
        int starIndex = -1, matchIndex = 0;

        while (sIndex < sLen) {
            if (pIndex < pLen && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))) {
                sIndex++;
                pIndex++;
            } else if (pIndex < pLen && p.charAt(pIndex) == '*') {
                starIndex = pIndex;
                matchIndex = sIndex;
                pIndex++;
            } else if (starIndex != -1) {
                pIndex = starIndex + 1;
                sIndex = matchIndex + 1;
                matchIndex++;
            } else {
                return false;
            }
        }

        while (pIndex < pLen && p.charAt(pIndex) == '*') {
            pIndex++;
        }

        return pIndex == pLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a"));        // Output: false
        System.out.println(solution.isMatch("aa", "*"));        // Output: true
        System.out.println(solution.isMatch("cb", "?a"));       // Output: false
        System.out.println(solution.isMatch("adceb", "*a*b"));  // Output: true
        System.out.println(solution.isMatch("acdcb", "a*c?b")); // Output: false
    }
}
