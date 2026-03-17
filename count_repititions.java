class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int count1 = 0;
        int count2 = 0;
        int i = 0;
        int j = 0;

        while (count1 < n1) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
                if (j == len2) {
                    j = 0;
                    count2++;
                }
            }
            i++;
            if (i == len1) {
                i = 0;
                count1++;
            }
        }
        
        return count2 / n2;
    }
}
