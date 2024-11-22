import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<=n; i++) list.add(i);
        
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i+1; j<=n; j++) {
                sum += j;
                if(sum > n) break;
                if(sum == n) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}