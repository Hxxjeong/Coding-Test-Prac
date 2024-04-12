import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 이름: 순위로 HashMap
        HashMap<String, Integer> rank = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            rank.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++) {
            int nameIndex = rank.get(callings[i]);
            String tmp = players[nameIndex-1];
            players[nameIndex-1] = players[nameIndex];
            players[nameIndex] = tmp;
            
            // 순위 갱신
            rank.put(players[nameIndex], nameIndex);
            rank.put(players[nameIndex-1], nameIndex-1);
        }
        
        return players;
    }
}