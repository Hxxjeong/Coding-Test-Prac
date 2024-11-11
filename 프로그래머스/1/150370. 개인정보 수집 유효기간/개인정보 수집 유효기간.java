import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        
        int toDay = convert(today);
        
        // 약관 - 개월 수
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<terms.length; i++) {
            String[] paper = terms[i].split(" ");
            map.put(paper[0], Integer.parseInt(paper[1]));
        }
        
        for(int i=0; i<privacies.length; i++) {
            String[] input = privacies[i].split(" ");
            int startDay = convert(input[0]);
            
            // 유효기간 날짜 계산
            int month = map.get(input[1]);
            int expiryDay = startDay + (month * 28);
            
            // 오늘이 해당 날짜이거나 이후면 파기
            if (toDay >= expiryDay) list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
    
    // 일 수로 계산
    public int convert(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        return (year * 12 * 28) + (month * 28) + day;
    }
}