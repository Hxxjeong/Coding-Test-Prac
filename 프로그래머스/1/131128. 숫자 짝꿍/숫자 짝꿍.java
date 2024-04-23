import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] intX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] intY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        for(int i=0; i<X.length(); i++) {
            intX[X.charAt(i) - '0']++;
        }
        
        for(int i=0; i<Y.length(); i++) {
            intY[Y.charAt(i) - '0']++;
        }
        
        List<Integer> number = new ArrayList<>();
        for(int i=9; i>=0; i--) {
            if(intX[i] != 0 || intY[i] != 0) {
                int min = Math.min(intX[i], intY[i]);
                answer += String.valueOf(i).repeat(min);    // 최소 개수만큼 넣기
            }
        }
        
        if(answer.length() == 0)
            return "-1";
        else if(answer.charAt(0) == '0')
            return "0";
        
        return answer;
    }
}