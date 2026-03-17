class Solution {
    public int integerReplacement(int n) {
        long ln = n; // Use long to avoid overflow when doing n + 1
        int steps = 0;

        while (ln != 1) {
            if (ln % 2 == 0) {
                ln /= 2;
            } else {
                // If the number is 3 or ends in 01 in binary, subtract 1
                if (ln == 3 || (ln & 2) == 0) {
                    ln--;
                } else {
                    // If it ends in 11 in binary, adding 1 creates more trailing zeros
                    ln++;
                }
            }
            steps++;
        }
        return steps;
    }
}
