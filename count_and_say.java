public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String previous = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        
        int count = 1;
        char currentChar = previous.charAt(0);
        
        for (int i = 1; i < previous.length(); i++) {
            if (previous.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(count).append(currentChar);
                currentChar = previous.charAt(i);
                count = 1;
            }
        }
        
        result.append(count).append(currentChar);
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(1));  // Output: "1"
        System.out.println(solution.countAndSay(2));  // Output: "11"
        System.out.println(solution.countAndSay(3));  // Output: "21"
        System.out.println(solution.countAndSay(4));  // Output: "1211"
        System.out.println(solution.countAndSay(5));  // Output: "111221"
    }
}
