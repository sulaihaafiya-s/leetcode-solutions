public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int[] product = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + product[i + j + 1];

                product[i + j + 1] = sum % 10; // Set the current index
                product[i + j] += sum / 10; // Carry over to the next index
            }
        }

        StringBuilder result = new StringBuilder();
        for (int num : product) {
            if (!(result.length() == 0 && num == 0)) {
                result.append(num);
            }
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("2", "3"));          // Output: "6"
        System.out.println(solution.multiply("123", "456"));      // Output: "56088"
        System.out.println(solution.multiply("0", "12345"));      // Output: "0"
        System.out.println(solution.multiply("999", "999"));      // Output: "998001"
    }
}
