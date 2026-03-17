import java.util.*;

class Solution {
    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (char c : hand.toCharArray()) handCount[c - 'A']++;
        Map<String, Integer> memo = new HashMap<>();
        int res = dfs(board + "#", handCount, memo);
        return res == 100 ? -1 : res;
    }

    private int dfs(String board, int[] handCount, Map<String, Integer> memo) {
        board = removeDuplicates(board);
        if (board.equals("#")) return 0;
        String state = board + Arrays.toString(handCount);
        if (memo.containsKey(state)) return memo.get(state);

        int res = 100;
        for (int i = 0; i < board.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (handCount[j] > 0) {
                    char c = (char) ('A' + j);
                    boolean worthTrying = false;
                    if (board.charAt(i) == c) worthTrying = true;
                    else if (i > 0 && board.charAt(i) == board.charAt(i - 1) && board.charAt(i) != c) worthTrying = true;

                    if (worthTrying) {
                        handCount[j]--;
                        res = Math.min(res, 1 + dfs(board.substring(0, i) + c + board.substring(i), handCount, memo));
                        handCount[j]++;
                    }
                }
            }
        }
        memo.put(state, res);
        return res;
    }

    private String removeDuplicates(String board) {
        for (int i = 0, j = 0; j < board.length(); j++) {
            if (board.charAt(i) == board.charAt(j)) continue;
            if (j - i >= 3) return removeDuplicates(board.substring(0, i) + board.substring(j));
            else i = j;
        }
        return board;
    }
}
