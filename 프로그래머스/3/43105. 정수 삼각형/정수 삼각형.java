import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0]; // 초기화

        for(int i=1; i<n; i++) {
            for(int j=0; j<=i; j++) {
                // 제일 왼쪽 (오른쪽에서만 뻗어나옴)
                if(j == 0) dp[i][j] = dp[i-1][j] + triangle[i][j];
                // 제일 오른쪽 (왼쪽에서만 뻗어나옴)
                else if(j == i) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                // 중간
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
        
        return Arrays.stream(dp[n-1]).max().getAsInt();
    }
}