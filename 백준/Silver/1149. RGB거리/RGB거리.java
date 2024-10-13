import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3];   // 각 집을 RGB로 칠하는 비용
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            cost[i][0] = Integer.parseInt(input[0]);
            cost[i][1] = Integer.parseInt(input[1]);
            cost[i][2] = Integer.parseInt(input[2]);
        }

        int[][] dp = new int[N][3];

        // 초기화 (첫번째 집 칠하는 비용)
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for(int i=1; i<N; i++) {
            // 최적해가 누적되기 때문에 이전의 집만 확인해도 ok
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]); // R (빨강 비용 + 초록이나 파랑으로 칠하는 경우 중 최소 비용)
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]); // G
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]); // B
        }

        // 마지막 집에서의 최소 비용 (첫번째 집 색에 따라 결과 도출)
        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));

        br.close();
    }
}