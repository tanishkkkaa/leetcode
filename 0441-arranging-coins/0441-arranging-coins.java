class Solution {
    public int arrangeCoins(int n) {
        long left = 0; // Minimum possible complete rows
        long right = n; // Maximum possible complete rows
        
        while (left <= right) {
            long mid = left + (right - left) / 2; // Calculate mid-point
            
            long totalCoins = (mid * (mid + 1)) / 2; // Calculate total coins required for mid rows
            
            if (totalCoins == n) {
                return (int)mid; // If exact number of coins match, return mid as number of complete rows
            } else if (totalCoins < n) {
                left = mid + 1; // If total coins are less, move to the right half
            } else {
                right = mid - 1; // If total coins are more, move to the left half
            }
        }
        
        return (int)right;
    }
}