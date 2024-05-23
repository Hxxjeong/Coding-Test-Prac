import java.util.*;

class Solution {
    public boolean isValid(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        int i=0;
        while(i < s.length()) {
            char parenthesis = s.charAt(i);
            if(parenthesis == '(' || parenthesis == '[' || parenthesis == '{') {
                stack.push(parenthesis);
            }
            else {
                if(stack.size() == 0) {answer = false; break;}
                else {
                    switch(parenthesis) {
                        case ')':
                        if(stack.peek() == '(') {
                            stack.pop();
                        }
                        else answer = false;
                        break;
                        case '}':
                        if(stack.peek() == '{') {
                            stack.pop();
                        }
                        else answer = false;
                        break;
                        case ']':
                        if(stack.peek() == '[') {
                            stack.pop();
                        }
                        else answer = false;
                        break;
                    }
                }
            }
            i++;
        }

        if(stack.size() != 0) answer = false;
        
        return answer;
    }
}