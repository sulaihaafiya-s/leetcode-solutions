class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = (minutesToTest / minutesToDie) + 1;
        int pigs = 0;
        long maxBuckets = 1;
        
        while (maxBuckets < buckets) {
            maxBuckets *= states;
            pigs++;
        }
        
        return pigs;
    }
}
