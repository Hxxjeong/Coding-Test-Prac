import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int[] hIndex = new int[citations.length];
        for(int i=citations.length-1; i>=0; i--) {
            // 논문 n편 증, a번 이상 인용된 논문이 b편 이상이면 a와 b중 작은 값이 H-Index
            int a = citations[i];
            hIndex[i] = Math.min(a, citations.length-1-i+1);
        }
        
        // H-Index 중 최대 값
        answer = Arrays.stream(hIndex).max().orElse(1);
        
        return answer;
    }
}