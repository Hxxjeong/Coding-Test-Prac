class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        while (right-left+1 != 0) {
            if(left % Math.sqrt(left) == 0)
                answer -= left;
            else answer += left;
            left++;
        }
        
        return answer;
    }
}