import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;

        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=1; j<=n; j++) {  // 1부터 n까지 길이를 늘리면서 하나씩 추가
                sum += elements[(i+j-1) % n];
                set.add(sum);
            }
        }

        return set.size();
    }
}