class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i = 0 ; i < piles.length ; i++){
            high = Math.max(high, piles[i]);
        }
        
        while (low <= high) {
            int mid = (low + high) / 2;
            long value = 0;
            for (int i = 0; i < piles.length; i++) {
                value += (long) Math.ceil((double) piles[i] / mid);
            }
            if (value <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}