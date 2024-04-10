import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int answer[] = new int[commands.length];
        
        for (int i=0; i<answer.length; i++) {
            int first = commands[i][0];     // 시작
            int second = commands[i][1];    // 끝
            int third = commands[i][2];     // k번째
            
            int[] newArray = Arrays.copyOfRange(array, first-1, second);
            Arrays.sort(newArray);
            
            answer[i] = newArray[third-1];
        }
        
        return answer;
    }
}