import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> runner = new HashMap<>();
        for(String s: participant) {
            runner.put(s, runner.getOrDefault(s, 0) + 1);
        }
        
        for(String s: completion) {
            if(runner.keySet().contains(s)) {
                runner.replace(s, runner.getOrDefault(s, 0) - 1);
            }
        }
        
        for(Map.Entry<String, Integer> entry: runner.entrySet()) {
            if(entry.getValue() > 0) {
                answer += entry.getKey();
                break;
            }
        }
        return answer;
    }
}