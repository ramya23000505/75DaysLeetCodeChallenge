class Solution {
    public double averageWaitingTime(int[][] customers) {
        long curtime = 0l, tottime =0l;
        for(int c[]: customers){
            int arrival = c[0];
            int prep = c[1];
            if(curtime<arrival){
                curtime=arrival;
            }
            curtime+=prep;
            tottime+=curtime-arrival;
        }        
        return (double) tottime/customers.length;
    }
}