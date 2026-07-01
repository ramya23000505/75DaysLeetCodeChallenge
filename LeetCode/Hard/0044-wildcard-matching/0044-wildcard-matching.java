class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[][]= new boolean[p.length()+1][s.length()+1];
        dp[0][0]=true;
        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)== '*'){
                dp[i][0]=dp[i-1][0];
            }
        }
        for(int i=1;i<=p.length();i++){
            char pc = p.charAt(i-1);
            for(int j=1;j<=s.length();j++){
                char sc = s.charAt(j-1);
                if(pc=='*'){
                   dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }
                else if(pc==sc|| '?'==pc){
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }
        return dp[p.length()][s.length()];   
    }    
}