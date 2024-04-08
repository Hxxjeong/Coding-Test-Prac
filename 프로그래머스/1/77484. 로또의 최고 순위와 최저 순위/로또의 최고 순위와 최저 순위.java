import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];        
        
        int count = 0;
        int countZero = 0;
        
        // count에 따른 순위
        HashMap<Integer, Integer> rank = new HashMap<>();
        rank.put(6, 1);
        rank.put(5, 2);
        rank.put(4, 3);
        rank.put(3, 4);
        rank.put(2, 5);
        rank.put(1, 6);
        rank.put(0, 6);
        
        // array to ArrayList
        ArrayList<Integer> lotto = new ArrayList<>();
        for(int i: lottos)
            lotto.add(i);
        
        ArrayList<Integer> win = new ArrayList<>();
        for(int j: win_nums)
            win.add(j);
        
        // 번호에 따른 결과 계산
        for (int k: lotto) {
            if(win.contains(k))
                count++;
        }
        
        for(int i=0; i<lotto.size(); i++) {
            if(lotto.get(i) == 0)
                countZero++;
        }
        
        answer[0] = rank.get(count + countZero);    // 최고 등수
        answer[1] = rank.get(count);    // 최저 등수
        
        return answer;
    }
}