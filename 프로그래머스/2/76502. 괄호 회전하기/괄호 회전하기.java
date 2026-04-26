import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<s.length(); i++) {
            if(right(sb)) answer++;
            char first = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);
        }
        
        return answer;
    }
    
    private static boolean right(StringBuilder sb) {
        Stack<Character> stack = new Stack<>();
        
        for(char c: sb.toString().toCharArray()) {
            if(c == '(' || c == '{' || c == '[') stack.add(c);
            else if (c == ')') {
                if(stack.isEmpty()) return false;
                else if(stack.peek() == '(') stack.pop();
                else return false;
            }
            else if (c == '}') {
                if(stack.isEmpty()) return false;
                else if(stack.peek() == '{') stack.pop();
                else return false;
            }
            else if (c == ']') {
                if(stack.isEmpty()) return false;
                else if(stack.peek() == '[') stack.pop();
                else return false;
            }
        }
        
        return stack.isEmpty();
    }
}