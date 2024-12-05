import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()) {
            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty() || stack.peek() == ')') return false;
                else if(stack.peek() == '(') stack.pop();
            }
        }
        
        answer = stack.isEmpty() ? true : false;

        return answer;
    }
}