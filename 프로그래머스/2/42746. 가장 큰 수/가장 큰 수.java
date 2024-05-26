import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] str = new String[numbers.length];
        for(int i=0; i<numbers.length; i++)
            str[i] = numbers[i] + "";
        
        Arrays.sort(str, new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                // 연속된 두 개의 문자열을 더해 더 큰 값 return
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        for(String s: str)
            answer += s;
        
        return str[0].equals("0") ? "0" : answer;
    }
}