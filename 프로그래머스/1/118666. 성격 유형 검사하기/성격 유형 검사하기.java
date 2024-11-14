import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int score = choices[i];
            
            // 4보다 크면 뒤의 항목에 점수 추가, 아니면 앞의 항목에 점수 추가
            if(score > 4) map.put(second, map.getOrDefault(second, 0) + score-4);
            else map.put(first, map.getOrDefault(first, 0) + Math.abs(4-score));
        }
        
        answer += map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T';
        answer += map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F';
        answer += map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M';
        answer += map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N';
        
        return answer;
    }
}