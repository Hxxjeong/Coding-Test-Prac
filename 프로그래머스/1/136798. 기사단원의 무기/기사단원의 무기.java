class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <=number; i++) {
            int len = getNumber(i);
            if(len > limit) {
                len = power;
            }
            answer += len;
        }
        return answer;
    }
    
    public int getNumber(int n) { //약수구하는 메서드
        int count = 0;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                if(i == n / i) {
                    count += 1;
                }
                else {
                    count += 2;
                }
            }
        }
        return count;
    }
}