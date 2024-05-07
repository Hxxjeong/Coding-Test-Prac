class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // 소수인지 판별하는 배열
        boolean[] primes = new boolean[3001];
        
        for (int i=2; i<=3000; i++)
            primes[i] = true;
        
        for (int i=2; i*i<=3000; i++) {
            for (int j=i*i; j<=3000; j+=i) {
                primes[j] = false;
            }
        }
        
        // 합이 소수 배열의 인덱스에 해당하면 추가
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    int number = nums[i] + nums[j] + nums[k];
                    if(primes[number]) answer++;
                }
            }
        }

        return answer;
    }
}