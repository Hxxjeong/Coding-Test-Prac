import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        int sum = Arrays.stream(d).sum();
        
        for(int i=d.length-1; i>=0; i--) {
            if(sum <= budget) {
                answer++;
            }
            sum -= d[i];
        }
        
        
        return answer;
    }
}