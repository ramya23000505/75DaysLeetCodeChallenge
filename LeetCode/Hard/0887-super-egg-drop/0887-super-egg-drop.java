class Solution {
    public int superEggDrop(int k, int N) {
        int dp[][] = new int [k+1][N+1];
        for(int i=1;i<=N;i++){
            dp[1][i]=i;
        }
        for(int i=1;i<=k;i++){
            dp[i][1]=1;
        }
        for(int e=2;e<=k;e++){
            for(int f=2;f<=N;f++){
                int lo=2, hi=f;
                int res=f;
                while(lo<=hi){
                    int x=lo+(hi-lo)/2;
                    int broken=dp[e-1][x-1];
                    int safe=dp[e][f-x];
                    int worst = Math.max(broken,safe);
                    res = Math.min(worst,res);
                    if(broken>safe) hi=x-1;
                    else lo=x+1;
                }
                 dp[e][f] = res+1;
            }
            
        }
        return dp[k][N];
    }
    
}