import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        
        // 알파벳 별 이동 횟수 계산
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            answer += Math.min(c-'A','Z'-c+1);
        }
        
        // A가 있는 것을 감안하여 정방향과 역방향 중 작은 값이 좌우 최소 이동 횟수
        int minMove = len-1;  // 정방향 이동 시 최소 이동
        
        for(int i=0; i<len; i++) {
            int next = i+1;
            
            // 연속된 A 확인
            while(next< len && name.charAt(next) == 'A') next++;
            
            // 최소 이동 횟수
            minMove = Math.min(minMove, i+len-next + Math.min(i, len-next));
        }

        answer += minMove;

        return answer;   
    }
}