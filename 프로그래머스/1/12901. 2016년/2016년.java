import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        // 요일 배열
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        
        Calendar cal = Calendar.getInstance();
        cal.set(2016, a-1, b);
        answer += day[cal.get(cal.DAY_OF_WEEK)-1];  // 1부터 시작이므로 -1
        
        return answer;
    }
}