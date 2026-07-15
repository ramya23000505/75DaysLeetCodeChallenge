class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
    int diff[] = new int[1001];
    for(int a[]: trips){
        diff[a[1]]+=a[0];
        diff[a[2]]-=a[0];
    }
    int curCap=0;
    for(int i=0;i<1001;i++){
        curCap+=diff[i];
        if(curCap>capacity) return false;
    }
    return true;
    }
}