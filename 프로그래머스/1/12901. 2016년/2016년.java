import java.util.*;

class Solution {
    public String solution(int a, int b) {
      String answer = "";
        
      // 각 월의 날짜
      int[] lastDay = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      String[] day ={"FRI","SAT","SUN","MON","TUE","WED","THU"};
        
      int totalDate = 0;
      for(int i=0; i<a-1; i++){
          totalDate += lastDay[i];
      }

      totalDate += b-1;
      answer = day[totalDate % 7];

      return answer;
  }
}