class Solution {
    public long minimumDifference(int[] nums) {
        int len=nums.length;
        int n = len/3;
        long left[] = new long[len];
        long right[] = new long[len];
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)-> b-a); 
        PriorityQueue<Integer> minheap = new PriorityQueue<>();   
        long sum=0;
        for(int i=0;i<len;i++){
            sum+=nums[i];
            maxheap.offer(nums[i]);
            if(maxheap.size()>n){
                sum-=maxheap.poll();
            }
            left[i]=sum;
        }      
        sum=0;
        for(int i=len-1;i>=0;i--){
            sum+=nums[i];
            minheap.offer(nums[i]);
            if(minheap.size()>n){
                sum-=minheap.poll();
            }
            right[i]=sum;
        }      
        long res = Long.MAX_VALUE;
        for(int i=n-1;i<2*n;i++){
            res = Math.min(res,left[i]-right[i+1]);
        }
        return res;
    }
}