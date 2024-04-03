class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] divisors = new int[number];
        for(int i=0; i<divisors.length; i++) {
            for(int j=1; j<=Math.sqrt(i+1); j++) {  // 제곱근까지 판별
                if((i+1)%j == 0) {
                    if((i+1) / j == j)  // 제곱근에 해당하는 경우
                        divisors[i]++;
                    else
                        divisors[i] += 2;
                }
            }
        }
        
        for(int i=0; i<divisors.length; i++) {
            if(divisors[i] <= limit) {
                answer += divisors[i];
            }
            else {
                answer += power;
            }
        }
        
        return answer;
    }
}