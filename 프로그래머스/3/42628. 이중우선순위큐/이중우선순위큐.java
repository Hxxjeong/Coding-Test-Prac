import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> ascQueue = new PriorityQueue<>();    // 오름차순
        PriorityQueue<Integer> descQueue = new PriorityQueue<>(Collections.reverseOrder());   // 내림차순
        
        for(String str: operations) {
            String[] s = str.split(" ");
            
            switch(s[0]) {
                case "I":   // 삽입
                    ascQueue.add(Integer.parseInt(s[1]));
                    descQueue.add(Integer.parseInt(s[1]));
                    break;
                case "D":   // 삭제
                    // 큐가 비어있는 경우 삭제 연산 무시
                    if(ascQueue.isEmpty()) break;
                    // 최댓값 삭제
                    else if(s[1].equals("1")) ascQueue.remove(descQueue.poll());
                    // 최솟값 삭제
                    else descQueue.remove(ascQueue.poll());
                    break;
            }
        }
        
        if(ascQueue.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            answer[0] = descQueue.peek();
            answer[1] = ascQueue.peek();
        }
        
        return answer;
    }
}