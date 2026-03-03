import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        int lastInvalidIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    lastInvalidIndex = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLength = Math.max(maxLength, i - lastInvalidIndex);
                    } else {
                        maxLength = Math.max(maxLength, i - stack.peek());
                    }
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()"));        // Output: 2
        System.out.println(solution.longestValidParentheses(")()())"));     // Output: 4
        System.out.println(solution.longestValidParentheses(""));           // Output: 0
        System.out.println(solution.longestValidParentheses("()(()"));      // Output: 2
        System.out.println(solution.longestValidParentheses("()()"));       // Output: 4
    }
}
