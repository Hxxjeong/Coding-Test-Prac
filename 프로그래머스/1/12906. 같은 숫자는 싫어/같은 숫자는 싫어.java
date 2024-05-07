import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        for(int i=1; i<arr.length; i++) {
            if(!stack.peek().equals(arr[i])) {
                stack.push(arr[i]);
            }
        }
        
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }

        int[] answer = new int[list.size()];
        for(int i=list.size()-1; i>=0; i--) {
            answer[answer.length-1-i] = list.get(i);
        }
        
        return answer;
    }
}