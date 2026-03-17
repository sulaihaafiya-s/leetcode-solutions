import java.util.*;

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price, special, needs, new HashMap<>());
    }

    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) return memo.get(needs);

        int res = 0;
        for (int i = 0; i < needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }

        for (List<Integer> offer : special) {
            List<Integer> nextNeeds = new ArrayList<>();
            boolean valid = true;
            for (int i = 0; i < needs.size(); i++) {
                if (needs.get(i) < offer.get(i)) {
                    valid = false;
                    break;
                }
                nextNeeds.add(needs.get(i) - offer.get(i));
            }

            if (valid) {
                res = Math.min(res, offer.get(needs.size()) + helper(price, special, nextNeeds, memo));
            }
        }

        memo.put(needs, res);
        return res;
    }
}
