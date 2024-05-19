import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(section[0]);
        
        for(int i=1; i<section.length; i++) {
            if(section[i] > stack.peek()+m-1)
                stack.push(section[i]);
        }
        
        return stack.size();
    }
}