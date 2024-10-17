class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = nums[0];
        for(int i = 0; i < nums.length ; i++){
            high = Math.max(high, nums[i]);
        }
        while(low <= high){
            int mid = (low+high)/2;
            int value = 0;
            for(int i = 0 ; i < nums.length ;i++){
                value += (nums[i] + mid -1) / mid;
            }
            if (value <= threshold) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}