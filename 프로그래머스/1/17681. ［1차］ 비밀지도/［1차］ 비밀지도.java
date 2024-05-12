import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[] orArr = new int[n];
        for(int i=0; i<n; i++) {
            orArr[i] = arr1[i] | arr2[i];
        }
        
        for(int i=0; i<n; i++) {
            String[] s = new String[n];
            StringBuilder sb = new StringBuilder();
            
            while(orArr[i] != 0) {
                for(int j=0; j<n; j++) {
                    s[j] = "";

                    s[j] = "" + orArr[i] % 2;
                    orArr[i] /= 2;

                    s[j] = s[j].equals("1") ? "#" : " ";

                    sb.append(s[j]);
                }
            }
            answer[i] = sb.reverse().toString();
        }
        
        return answer;
    }
}