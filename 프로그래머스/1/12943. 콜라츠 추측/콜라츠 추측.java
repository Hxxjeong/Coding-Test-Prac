class Solution {
    public int solution(int num) {
        
        long n = num;
        int answer = 0;
        
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else {
                n = n * 3 + 1;
            }
            answer++;
            if (answer == 500) {
                answer = -1;
                break;
            }
        }
        
        if (num == 1)
            return 0;
        
        return answer;
    }
}