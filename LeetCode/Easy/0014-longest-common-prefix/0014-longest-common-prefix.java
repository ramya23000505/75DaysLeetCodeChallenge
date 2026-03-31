class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);        
        String start=strs[0];
        String end = strs[strs.length-1];
        int idx=0;
        while(idx<start.length() && idx<end.length()){
            if(start.charAt(idx)==end.charAt(idx)){
                idx++;
            }
            else{
                break;
            }
        }
        return start.substring(0,idx);
    }
}