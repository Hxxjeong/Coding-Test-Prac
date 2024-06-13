import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = n;
        
        Integer[][] result = new Integer[n+1][n+1]; // null로 초기화하기 위함
        for(int i=0; i<=n; i++) {
            result[i][i] = 0;   // 자신과는 경기 X
        }
        
        for(int i=0; i<results.length; i++) {
            for(int j=0; j<results[i].length; j++) {
                int win = results[i][0];
                int lose = results[i][1];
                
                result[win][lose] = 1;  // win이 lose에게 이겼을 때 1
                result[lose][win] = -1;  // lose가 win에게 졌을 때 -1
            }
        }
        
         for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (result[i][k] != null && result[k][j] != null && result[i][k] == 1 && result[k][j] == 1) {   // i가 k를 이기고 k가 j를 이기면 i는 j를 이김
                        result[i][j] = 1;
                        result[j][i] = -1;
                    }
                }
            }
        }

        // 배열의 행에서 null이 없으면 순위를 매길 수 있음
        for (int i=1; i<=n; i++) {
            boolean hasNull = false;
            for (int j=1; j<=n; j++) {
                if (result[i][j] == null) {
                    hasNull = true;
                    break;
                }
            }
            if (hasNull) answer--; // null이 포함된 행이 있으면 answer 감소
        }
        
        return answer;
    }
}