import java.util.*;

class Solution {
    public Integer[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int progress = (int)Math.ceil((100 - progresses[i]) / (double)speeds[i]);
            queue.add(progress);
        }
        
        while(!queue.isEmpty()) {
            int days = queue.poll();
            int count = 1;
            
            // 앞에 있는 기능이 먼저 배포되어야 함
            while(!queue.isEmpty() && days >= queue.peek()) {
                count++;
                queue.poll();
            }
            answer.add(count);
        }
        
        return answer.toArray(new Integer[0]);
    }
}