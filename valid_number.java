public class Solution {
    public boolean isNumber(String s) {
        String regex = "[+-]?((\\d+\\.\\d*)|(\\.\\d+)|(\\d+))([eE][+-]?\\d+)?";
        return s.trim().matches(regex);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNumber("2"));                  // Output: true
        System.out.println(solution.isNumber("0089"));               // Output: true
        System.out.println(solution.isNumber("-0.1"));               // Output: true
        System.out.println(solution.isNumber("+3.14"));              // Output: true
        System.out.println(solution.isNumber("4."));                 // Output: true
        System.out.println(solution.isNumber("-.9"));                // Output: true
        System.out.println(solution.isNumber("2e10"));               // Output: true
        System.out.println(solution.isNumber("-90E3"));              // Output: true
        System.out.println(solution.isNumber("3e+7"));               // Output: true
        System.out.println(solution.isNumber("+6e-1"));              // Output: true
        System.out.println(solution.isNumber("53.5e93"));            // Output: true
        System.out.println(solution.isNumber("-123.456e789"));       // Output: true
        System.out.println(solution.isNumber("abc"));                // Output: false
        System.out.println(solution.isNumber("1a"));                 // Output: false
        System.out.println(solution.isNumber("1e"));                 // Output: false
        System.out.println(solution.isNumber("e3"));                 // Output: false
        System.out.println(solution.isNumber("99e2.5"));             // Output: false
        System.out.println(solution.isNumber("--6"));                // Output: false
        System.out.println(solution.isNumber("-+3"));                // Output: false
        System.out.println(solution.isNumber("95a54e53"));           // Output: false
    }
}
