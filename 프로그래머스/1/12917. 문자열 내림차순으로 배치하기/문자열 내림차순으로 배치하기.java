import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] c = s.toCharArray();
        
        Arrays.sort(c);
        
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.reverse();
        
        return sb.toString();
        
    }
}