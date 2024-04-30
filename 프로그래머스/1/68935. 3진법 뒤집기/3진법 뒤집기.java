class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            sb.append(n%3);
            n /= 3;
        }
        
        sb.reverse();
        int[] num = new int[sb.length()];
        for(int i=0; i<num.length; i++) {
            num[i] = sb.charAt(i) - '0';
        }
        
        for(int i=0; i<num.length; i++) {
            num[i] = (int)Math.pow(3, i) * num[i];
            answer += num[i];
        }
        
        return answer;
    }
}