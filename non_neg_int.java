class Solution {
    public int findIntegers(int n) {
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < 32; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        int ans = 0, lastBit = 0;
        for (int i = 30; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (bit == 1) {
                ans += f[i];
                if (lastBit == 1) {
                    return ans;
                }
            }
            lastBit = bit;
        }

        return ans + 1;
    }
}
