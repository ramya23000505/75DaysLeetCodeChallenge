class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack <Integer> stack = new Stack<>();
        int nextgreater[] = new int[10001];

        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.empty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            nextgreater[nums2[i]] = stack.empty()? -1: stack.peek();
            stack.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]= nextgreater[nums1[i]];
        }
        return nums1;
    }
}