import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 사용자 id: 인덱스
        Map<String, Integer> id = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            id.put(id_list[i], i);
        }
        
        // 중복 신고 제거
        HashSet<String> set = new HashSet<>();
        for(String s: report)
            set.add(s);
        String[] list = set.toArray(new String[0]);
        
        List<String> reportor = new ArrayList<>();  // 신고한 사람
        List<String> reported = new ArrayList<>();  // 신고 받은 사람
        
        // 신고자와 신고를 받은 자 리스트에 추가
        for(int i=0; i<list.length; i++) {
            String[] reportArr = list[i].split(" ");
            reportor.add(reportArr[0]);
            reported.add(reportArr[1]);
        }
        
        // 신고 받는 사람: 신고 받은 횟수
        Map<String, Integer> countReport = new HashMap<>();
        for(int i=0; i<reported.size(); i++) {
            String reportedUser = reported.get(i);
            countReport.put(reportedUser, countReport.getOrDefault(reportedUser, 0) + 1);
        }
        
        // 신고 받은 횟수가 k번 이상이면 신고자에게 알림
        List<Integer> indexList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: countReport.entrySet()) {
            if(entry.getValue() >= k) {
                String target = entry.getKey();
                for (int i=0; i<reported.size(); i++) {
                    if (reported.get(i).equals(target)) {
                        String user = reportor.get(i);
                        answer[id.get(user)]++;
                    }
                }
            }
        }
        
        return answer;
    }
}