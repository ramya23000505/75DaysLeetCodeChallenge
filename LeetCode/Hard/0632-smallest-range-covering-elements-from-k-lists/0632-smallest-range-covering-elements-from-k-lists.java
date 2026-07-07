class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int start=0, end=Integer.MAX_VALUE, cmax= Integer.MIN_VALUE;
        PriorityQueue <int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(int i=0;i<nums.size();i++){
            int val =nums.get(i).get(0);
            pq.offer(new int[]{val,i,0});// i-list num,denotes0-list
            cmax=Math.max(cmax,val);
        }
        while(pq.size()==nums.size()){
            int cur[] = pq.poll();
            int cmin = cur[0];
            int list = cur[1];
            int ind = cur[2]; // [4val,0list,0index] from first value from 1st list likewise take out all 1st val from list into list
            if(cmax-cmin<end-start){
                start=cmin;
                end= cmax;
            }
            int nxtInd=ind+1;
            if(nxtInd>=nums.get(list).size()){
                break;
            }
            int nextVal = nums.get(list).get(nxtInd);
            pq.offer(new int[]{nextVal, list, nxtInd});

            cmax = Math.max(cmax, nextVal);
        }
        return new int[] {start,end};
    }
}