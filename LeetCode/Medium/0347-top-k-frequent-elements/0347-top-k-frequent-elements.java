class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer, Integer> hm = new HashMap<>();
        for(int i: nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        pq.addAll(hm.entrySet());
        int res[] = new int[k];
        for(int i=0;i<k;i++){
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}