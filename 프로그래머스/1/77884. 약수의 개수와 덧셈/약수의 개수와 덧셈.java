class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int count = 0;
        
        while (right-left+1 != 0) {
            for(int i=1; i<=left; i++) {
                if(left % i == 0)
                    count++;
            }
            if (count % 2 == 0)
                answer += left;
            else
                answer -= left;
            left++;
            count = 0;
        }
        
        return answer;
    }
}