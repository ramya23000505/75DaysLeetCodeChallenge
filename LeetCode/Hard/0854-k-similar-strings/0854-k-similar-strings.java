class Solution {
    void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
    public int kSimilarity(String s1, String s2) {
        if(s1.equals(s2)) return 0;
        Queue <String> qu = new LinkedList<>();
        HashSet <String> hs = new HashSet<>();
        int swaps=0;
        qu.add(s1);
        hs.add(s1);
        while(!qu.isEmpty()){
            int size = qu.size();
            while(size-- >0){
                s1=qu.poll();
                if(s1.equals(s2)) return swaps;
                int i=0;
                while(s1.charAt(i)==s2.charAt(i)) i++;
                char ch[] = s1.toCharArray();
                for(int j=i+1;j<s1.length();j++){
                    if(ch[j]==s2.charAt(i) && ch[j] != s2.charAt(j)){
                        swap(ch,i,j);
                        String next = new String(ch);
                        if(hs.add(next)){
                            qu.add(next);
                        }
                        swap(ch,i,j);
                    }
                }
            }
            swaps++;
        }
    return 0;       

    }

}