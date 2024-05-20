import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        // 정렬이 되어 있기 때문에 뒤의 문자열 비교
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}