class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int res[] = new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<2*n;i++){
            int curr = nums[i%n];
            while(!st.isEmpty() && nums[st.peek()]<curr){
                res[st.pop()]=curr;
            }
            if(i<n) st.push(i);
        }
        return res;
    }
}