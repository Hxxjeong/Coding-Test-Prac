import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        List<String> speak = List.of("aya", "ye", "woo", "ma");
        
        for(String s: babbling) {
            int index = 0; boolean flag = false; String beforeWord = "";
            for(int j=0; j<speak.size(); j++) {
                if(s.startsWith(speak.get(j), index) && !speak.get(j).equals(beforeWord)) {
                    index += speak.get(j).length();
                    beforeWord = speak.get(j);
                    j = -1; // 인덱스 초기화를 위한 코드
                }
                
                if(index == s.length()) flag = true;
            }
            if(flag) answer++;
        }
        return answer;
    }
}