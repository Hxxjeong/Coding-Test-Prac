import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i=citations.length-1; i>=0; i--) {
            // 논문 n편 증, a번 이상 인용된 논문이 b편 이상이면 a와 b중 작은 값이 H-Index
            int a = citations[i];
            int hIndex = Math.min(a, citations.length-1-i+1);
            
            // H-Index 중 최대값
            answer = Math.max(answer, hIndex);
        }
        
        return answer;
    }
}