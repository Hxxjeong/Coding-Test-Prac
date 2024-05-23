import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        int index = 0;
        
        for(int i=0; i<s.length(); i++) {
            index = i;
            char parenthesis = s.charAt(i);
            if(parenthesis == '(')
                stack.push(parenthesis);
            else {
                if(stack.size() == 0) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        
        if(stack.size() != 0) answer = false;

        return answer;
    }
}