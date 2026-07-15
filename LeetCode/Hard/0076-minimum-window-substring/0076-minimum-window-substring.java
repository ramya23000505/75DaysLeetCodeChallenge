class Solution {
    public String minWindow(String s, String t) {
        int [] need = new int[128];
        int [] window = new int[128];
        int req=0;
        for(char c: t.toCharArray()){
            if(need[c]==0){
                req++;
            }
            need[c]++;
        }
        int l=0;
        int st=0;
        int min = Integer.MAX_VALUE;
        int formation=0;
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            window[ch]++;
            if(need[ch]>0 && window[ch]==need[ch]){
                formation++;
            }
            while(formation==req){
                if(r-l+1<min){
                    min=r-l+1;
                    st=l;
                } 
                char c = s.charAt(l);
                window[c]--;
                if(need[c]>0 && window[c]<need[c]) formation--;
                l++;
            }
        }
        return (min==Integer.MAX_VALUE)? "" :s.substring(st, st+min);
    }
}