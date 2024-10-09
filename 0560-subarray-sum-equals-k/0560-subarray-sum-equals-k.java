class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        int sum = 0;
        int count = 0;

        //     {-2, 1, 2, -2, 5, -2, 1}
        //p s: {-2, -1, 1, -1, 4, 2, 3 }
        // prefixSum[j] - k = prefixSum[0, i-1]
        // This will store the prefixsum in the corresponding arrays

        for (int i = 0; i< nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }

        for (int j=0; j< prefixSum.length; j++) {
            // Need to calculate from i-1            
            if (prefixSum[j] == k) {
                count++;
                //System.out.println("count-1:"+ count);
            }
        }

        for (int j=1; j<prefixSum.length; j++) {  
            //System.out.println("prefixSum[j]: "+ prefixSum[j] + " k:" + k);          
            int diff = prefixSum[j] - k; 
            for(int i=1; i<=j; i++) {                               
                //System.out.println("prefixSum[j]-k: "+diff + " prefixSum[i-1]: " + prefixSum[i-1]);
                if (diff == prefixSum[i-1]) {
                    count++;
                }
                //System.out.println("count-2:"+ count);
            }
        }        
        return count;
    }
}