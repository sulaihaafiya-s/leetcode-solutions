import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        
        Stack<Character> stack = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            // While we still need to remove digits and the current digit 
            // is smaller than the top of the stack, pop the stack
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        // If we still need to remove digits (e.g., input was "123"), 
        // remove from the end
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // Build the string and remove leading zeros
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        
        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
