class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> b = new HashSet(Arrays.asList(bank));
        if(!b.contains(endGene)) return -1;
        int cnt=0;
        Queue<String> qu = new LinkedList<>();
        Set<String> vis =new HashSet<>();
        char replace[] = {'A','C', 'G','T'};
        qu.add(startGene);
        vis.add(startGene);
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0;i<size;i++){
                String cur = qu.poll();
                if(cur.equals(endGene)) return cnt;
                char arr[] = cur.toCharArray();
                for(int j=0;j<8;j++){
                    char temp=arr[j];
                    for(char ch: replace){
                        if(arr[j]==ch) continue;
                        arr[j]=ch;
                        String s = new String(arr);
                        if(b.contains(s) && !vis.contains(s)){
                            qu.add(s);
                            vis.add(s);
                        }
                        arr[j]=temp;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}