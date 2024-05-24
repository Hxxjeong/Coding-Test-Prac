import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i: scoville) {
            queue.add(i);
        }
        
        // 모든 원소가 K 이상을 만족할 때 바로 리턴
        if(queue.peek() >= K) return 0;
        
        
        // 모든 음식의 스코빌 지수가 K 이상이어야 함
        while(queue.peek() < K) {
            // queue가 비어 있지 않을 때 poll
            if(queue.isEmpty()) return -1;
            int first = queue.poll();
            
            if(queue.isEmpty()) return -1;
            int second = queue.poll();
            
            int mixed = first + (second * 2);
            
            queue.add(mixed);
            answer++;
        }
        
        // 만족하지 못하면 -1 리턴
        return answer == 0 ? -1 : answer;
    }
}