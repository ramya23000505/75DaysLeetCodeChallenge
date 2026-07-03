class Solution {
    HashMap <String,Boolean> hm = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        String key = s1 +"#"+ s2;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        
        int freq[] = new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }
        for(int i: freq){
            if(i!=0){
                hm.put(key,false);
                return false;
            } 
        }
        for(int i=1;i<s1.length();i++){
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))){
                hm.put(key,true);
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) &&
                isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {

                hm.put(key, true);
                return true;
            }
        }
        hm.put(key, false);
        return false;
    }
}