import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        int sum = (maxChoosableInteger * (1 + maxChoosableInteger)) / 2;
        if (sum < desiredTotal) return false;
        
        return canWin(desiredTotal, 0, maxChoosableInteger, new HashMap<>());
    }

    private boolean canWin(int target, int mask, int maxNum, Map<Integer, Boolean> memo) {
        if (memo.containsKey(mask)) return memo.get(mask);
        
        for (int i = 1; i <= maxNum; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) == 0) {
                if (target <= i || !canWin(target - i, mask | bit, maxNum, memo)) {
                    memo.put(mask, true);
                    return true;
                }
            }
        }
        
        memo.put(mask, false);
        return false;
    }
}
