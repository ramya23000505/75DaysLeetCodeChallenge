class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int left=0;
        int right=rows*cols-1;
        
        while(left<=right){
            int mid = left+ right-left/2;
            int val = matrix[mid/cols][mid%cols];
            if(val<target){
                left = mid+1;
            }
            else if(val>target){
                right=mid-1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}