class Solution {
    public int countNegatives(int[][] grid) {
       int rows = grid.length;
       int cols = grid[0].length;
       int count = 0;
       for(int i=0;i<rows;i++){
            int left = 0;
            int right = cols-1;
            while(left<=right){
                int mid = left+(right-left)/2;
                if(grid[i][mid]<0){
                    count+= right-mid+1;
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return count;
    }
}