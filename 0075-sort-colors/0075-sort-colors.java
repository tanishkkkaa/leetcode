class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int current = 0;
        
        while (current <= right) {
            if (nums[current] == 0) {
                int temp = nums[left];
                nums[left] = nums[current];
                nums[current] = temp;
                left++;
                current++;
            } else if (nums[current] == 2) {
                int temp = nums[right];
                nums[right] = nums[current];
                nums[current] = temp;
                right--;
            } else {
                current++;
            }
        }
    }
}
