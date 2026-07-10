class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int n=positions.length;
        int height[] = new int[n];
        int max=0;
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            height[i]=positions[i][1];
            int curst = positions[i][0];
            int curend = curst+ positions[i][1];
            for(int j=0;j<i;j++){
                int prevst = positions[j][0];
                int prevend = prevst+positions[j][1];
                if(curst<prevend && curend>prevst){
                    height[i] = Math.max(height[i],height[j]+positions[i][1]);
                }
            }
            max=Math.max(max, height[i]);
            li.add(max); 
        }
        return li;
    }
}