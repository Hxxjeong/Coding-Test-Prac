import java.util.*;

class Solution {
    public Integer[] solution(int N, int[] stages) {
        Integer[] answer = new Integer[N];
        int[] person = new int[N+1];
        HashMap<Integer, Double> fails = new HashMap<>();
        
        /*
        0 1 0 0 0 0	    2
        1 1 0 0 0 0	    1
        1 2 0 0 0 0	    2
        1 2 0 0 0 1	    6
        1 3 0 0 0 1	    2
        1 3 0 1 0 1     4
        1 3 1 1 0 1     3
        1 3 2 1 0 1     3
        */
        for(int i: stages) {
            person[i-1]++; 
        }
        
        // 실패율 계산
        double total = stages.length;
        for(int i=0; i<person.length-1; i++) {
            double failureRate = (total == 0) ? 0 : person[i] / total;
            fails.put(i+1, failureRate);
            total -= person[i];
        }
        
        // 실패율 정렬
        ArrayList<Integer> keyList = new ArrayList<>(fails.keySet());
        keyList.sort((f1, f2) -> Double.compare(fails.get(f2), fails.get(f1)));
        
        // list to array
        answer = keyList.toArray(new Integer[0]);
        
        return answer;
    }
}