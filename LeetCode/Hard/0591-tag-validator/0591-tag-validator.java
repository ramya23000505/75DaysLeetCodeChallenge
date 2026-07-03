class Solution {
    public boolean isValid(String code) {
        Stack<String> st = new  Stack<>();
        int i=0;
        int n = code.length();
        while(i<n){
            if(i>0 && st.isEmpty()) return false;
            else if(code.startsWith("<![CDATA[",i)){
                if(st.isEmpty()) return false;
                int end = code.indexOf("]]>",i+9);
                if(end==-1) return false;
                i=end+3;
            }
            else if(code.startsWith("</",i)){
                if(st.isEmpty()) return false;
                int end = code.indexOf(">", i+2);
                if(end==-1) return false;
                String tag = code.substring(i+2,end);
                if(!tag.equals(st.pop())) return false;
                i=end+1;
            }
            else if(code.charAt(i)=='<'){
                int end = code.indexOf(">", i+1);
                if(end==-1) return false;
                String tag = code.substring(i+1,end);
                if(tag.length()<1 || tag.length()>9) return false;
                for(char ch : tag.toCharArray()){
                    if(ch<'A' || ch>'Z') return false;
                }
                st.push(tag);
                i=end+1;
            }
            else i++;
        }
        return st.isEmpty();
    }
}