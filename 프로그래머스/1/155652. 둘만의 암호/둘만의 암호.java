import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        // 알파벳 리스트
        List<Character> alpha = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            alpha.add((char) ('a' + i));
        }
        
        // skip에 있는 문자 제거
        for (int i=0; i<skip.length(); i++) {
            if(alpha.contains(skip.charAt(i))) {
                alpha.remove((Character)skip.charAt(i));
            }
        }
        
        char[] c = s.toCharArray();
        for (int i=0; i<c.length; i++) {
            int alphaIndex = alpha.indexOf(c[i]) + index;
            if(alphaIndex >= alpha.size()) {
                alphaIndex %= alpha.size();
                c[i] = alpha.get(alphaIndex);
            }
            else
                c[i] = alpha.get(alphaIndex);
            answer += c[i];
        }
        return answer;
    }
}