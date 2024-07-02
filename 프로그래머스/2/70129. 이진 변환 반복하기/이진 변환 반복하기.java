import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int count = 0;
        int removeZero = 0;
        
        while(!s.equals("1")) {
            char[] c = s.toCharArray();
            Arrays.sort(c);

            for(int i=0; i<c.length; i++) {
                if(c[i] == '1') {
                    removeZero += i;
                    s = Integer.toString(c.length-i, 2);    // 1의 개수 이진수로 변환
                    break;
                }
            }
            count++;
        }
        
        answer[0] = count; answer[1] = removeZero;
        
        return answer;
    }
}