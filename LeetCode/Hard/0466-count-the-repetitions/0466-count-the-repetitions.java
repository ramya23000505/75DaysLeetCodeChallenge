class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int s1cnt=0;
        int s2cnt=0;
        int s2ind=0;
        Map<Integer, int[]> hm = new HashMap<>();
        while(s1cnt<n1){
            for(int i=0;i<s1.length();i++){
                char ch = s1.charAt(i);
                if(ch==s2.charAt(s2ind)){
                    s2ind++;
                    if(s2ind==s2.length()){
                        s2ind=0;
                        s2cnt++;
                    }
                }
            }
            s1cnt++;
            if(hm.containsKey(s2ind)){
                int prev[]=hm.get(s2ind);
                int prevs1cnt = prev[0];
                int prevs2cnt = prev[1];
                int length = s1cnt-prevs1cnt;
                int gain = s2cnt-prevs2cnt;
                int remain = n1-s1cnt;
                int remaincyc = remain/length;
                s1cnt+= remaincyc*length;
                s2cnt+= remaincyc*gain;
            }
            else{
                hm.put(s2ind, new int[] {s1cnt,s2cnt});
            }
        }
        return s2cnt/n2;
    }
}