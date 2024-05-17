class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        int sumA = Arrays.stream(aliceSizes).sum();
        int sumB = Arrays.stream(bobSizes).sum();
        int delta = (sumB - sumA)/2;
        for(int i = 0 ; i < aliceSizes.length; i++){
            int target = aliceSizes[i] + delta;
            int left = 0; 
            int right = bobSizes.length-1;
            while(left<=right){
                int mid = left+(right-left)/2;
                if(bobSizes[mid]==target){
                    return new int[]{aliceSizes[i],bobSizes[mid]};
                }else if(bobSizes[mid]<target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return new int[]{-1,-1};
    }
}