class Solution {
    public long[] solution(int n, int m) {
        long[] answer = new long[2];
        
        // 최소공배수 = a * b / 최대공약수
        
        long x = Math.min(n, m);
        long y = Math.max(n, m);
        
        for(long i=x; i>=1; i--) {
            if(y % i == 0 && x % i == 0) {
                answer[0] = i;
                break;
            }
            else
                answer[0] = 1;
        }
        
        answer[1] = x * y / answer[0];
        
        return answer;
    }
}