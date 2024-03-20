class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] primes = new boolean[n+1];
        
        // 값 초기화
        for (int i=2; i<=n; i++)
            primes[i] = true;
        
        // 인덱스 값을 제외한 배수들을 제외
        for (int i=2; i*i<=n; i++) {
            for (int j=i*i; j<=n; j+=i) {
                primes[j] = false;
            }
        }
        
        // 소수 출력
        for (int i=2; i<=n; i++) {
            if (primes[i] == true)
                answer++;
        }
        
        return answer;
    }
}