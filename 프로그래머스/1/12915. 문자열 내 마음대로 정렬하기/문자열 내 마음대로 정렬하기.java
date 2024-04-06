import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                char c1 = s1.charAt(n);
                char c2 = s2.charAt(n);
                return Character.compare(c1, c2);
            }
        };
        
        Arrays.sort(strings, comparator);
        
        String[] answer = strings;
        return answer;
    }
}