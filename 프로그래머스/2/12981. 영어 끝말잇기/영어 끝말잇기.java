import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        
        for(int i=1; i<words.length; i++) {
            String past = words[i-1];
            String now = words[i];
            
            if(!list.contains(words[i]) && past.charAt(past.length()-1) == now.charAt(0)) {
                list.add(words[i]);
            }
            else {
                answer[0] = (i%n) + 1; // n번째 사람
                answer[1] = (i/n) + 1; // n번쨰 순서
                break;
            }
        }

        return answer;
    }
}
