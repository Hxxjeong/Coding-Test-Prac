import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++) map.put(want[i], number[i]);

        Map<String, Integer> windowMap = new HashMap<>();
        for(int i=0; i<10; i++) {
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0)+1);
        }

        if(isMatch(map, windowMap)) answer++;

        // 슬라이딩 윈도우
        for(int left=0, right=10; right<discount.length; left++, right++) {
            String removeItem = discount[left];
            windowMap.put(removeItem, windowMap.get(removeItem)-1);
            if (windowMap.get(removeItem) == 0) {
                windowMap.remove(removeItem);
            }

            String addItem = discount[right];
            windowMap.put(addItem, windowMap.getOrDefault(addItem, 0)+1);

            if (isMatch(map, windowMap)) answer++;
        }

        return answer;
    }

    private boolean isMatch(Map<String, Integer> map, Map<String, Integer> windowMap) {
        for (String key : map.keySet()) {
            if (!map.get(key).equals(windowMap.getOrDefault(key, 0))) {
                return false;
            }
        }
        return true;
    }
}