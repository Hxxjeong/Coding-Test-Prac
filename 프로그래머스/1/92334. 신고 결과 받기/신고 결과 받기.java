import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 사용자 - 인덱스
        Map<String, Integer> id = new HashMap<>();
        for(int i=0; i<id_list.length; i++) id.put(id_list[i], i);
        
        Set<String> set = new HashSet<>();
        for(String s: report) set.add(s);   // 중복 신고 제거
        String[] arr = set.toArray(new String[0]);
        
        List<String> from = new ArrayList<>();  // 신고한 사람
        List<String> to = new ArrayList<>();    // 신고 받은 사람
        for(int i=0; i<arr.length; i++) {
            String[] r = arr[i].split(" ");
            from.add(r[0]);
            to.add(r[1]);
        }
        
        // 신고 받은 사람 - 횟수
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<to.size(); i++) {
            map.put(to.get(i), map.getOrDefault(to.get(i), 0)+1);
        }
        
        // 신고 당한 횟수가 k번 이상이면 answer에 추가
        for(Map.Entry<String, Integer> e: map.entrySet()) {
            if(e.getValue() >= k) {
                String reported = e.getKey();
                for(int i=0; i<from.size(); i++) {
                    // 해당 유저를 신고한 경우
                    if(to.get(i).equals(reported)) {
                        String user = from.get(i);  // from과 to의 인덱스 동일
                        answer[id.get(user)]++;
                    }
                }
            }
        }
        
        return answer;
    }
}