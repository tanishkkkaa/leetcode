class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int element : nums){
            if(((int)(Math.log10(element))+1) %2 == 0) {
                count++;
            }
        }
        return count;
    }

   
}