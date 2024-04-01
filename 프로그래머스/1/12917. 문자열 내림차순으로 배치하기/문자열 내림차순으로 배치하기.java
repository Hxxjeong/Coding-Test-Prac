import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] c = new char[s.length()];
        for(int i=0; i<c.length; i++) {
            c[i] = s.charAt(i);
        }
        
        Arrays.sort(c);
        for (int i=c.length-1; i>=0; i--) {
            answer += c[i];
        }
        
        return answer;
        
    }
}