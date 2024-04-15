import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);   // 미리 정렬
        
        // n번째 인덱스를 제일 앞으로 위해
        for(int i=0; i<strings.length; i++) {
            strings[i] = strings[i].charAt(n) + strings[i];
        }
        
        Arrays.sort(strings);
        for(int i=0; i<strings.length; i++) {
            strings[i] = strings[i].substring(1);
        }
        
        return strings;
    }
}