class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int start = 0;
        int end = n-1;
        char result = letters[0];
        while(start<=end){
            int mid = start + (end - start)/2;
            if(letters[mid]>target){
                result = letters[mid];
                end = mid - 1;
            }else{
                start = mid+1;
            }
        }
        return result;
    }
}