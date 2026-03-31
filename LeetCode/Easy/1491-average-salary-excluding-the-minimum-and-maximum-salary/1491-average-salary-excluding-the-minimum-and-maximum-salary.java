class Solution {
    public double average(int[] salary) {
    Arrays.sort(salary);
    int sum=0;
    for(int i=0;i<salary.length;i++){
        sum+=salary[i];
    }
     return (sum - (salary[0] + salary[salary.length - 1])) 
                / (double)(salary.length - 2);
}
}