class Solution {
    public long solution(int n) {
        long[] fibo = new long[n+1];
        fibo[0] = 1;
        fibo[1] = 2;
        
        for (int i=2; i<fibo.length; i++) {
            fibo[i] = fibo[i-1]%1234567 + fibo[i-2]%1234567;
        }
        
        return fibo[n-1]%1234567;
    }
}