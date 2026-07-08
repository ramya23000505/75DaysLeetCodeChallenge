class Solution {
    public String countOfAtoms(String formula) {
        Stack <Map<String,Integer>> st = new Stack<>();
        st.push(new HashMap<>());
        int i=0, n = formula.length();
        while(i<n){
            char ch = formula.charAt(i);
            if(ch=='('){
                 st.push(new HashMap<>());
                 i++;
            }     
            else if(ch==')'){
                i++;
                int start =i;
                while(i<n && Character.isDigit(formula.charAt(i))) i++;
                int multi=(i==start? 1: Integer.parseInt(formula.substring(start,i)));
                Map<String,Integer> top = st.pop();
                Map<String,Integer> prev = st.peek();
                for(String atom: top.keySet()){
                    prev.put(atom, prev.getOrDefault(atom,0)+top.get(atom)*multi);
                }
            }
            else{
                int start=i;
                i++;
                while(i<n && Character.isLowerCase((formula.charAt(i)))) i++;
                String atom = formula.substring(start,i);
                start=i;
                while(i<n && Character.isDigit(formula.charAt(i))) i++;
                int count = (i==start ? 1: Integer.parseInt(formula.substring(start,i)));
                Map<String,Integer> curr = st.peek();
                curr.put(atom, curr.getOrDefault(atom,0)+count);
            } 
        }    
            TreeMap<String, Integer> res = new TreeMap<>(st.pop());      
            StringBuilder sb = new StringBuilder();
            for(String atom: res.keySet()){
                sb.append(atom);
                if(res.get(atom)>1){
                    sb.append(res.get(atom));
                }                
            }    
        return sb.toString();
    }
}