import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        while(left <= right) {
            if(people[left] + people[right] <= limit) left++;
            right--;
            answer++;   // 무거운 사람의 보트 추가
        }
        
        return answer;
    }
}