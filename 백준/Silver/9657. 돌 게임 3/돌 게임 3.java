import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[Math.max(5, N+1)];
        dp[1] = true;
        dp[2] = false;  // Sk 1, CY 1 이므로 무조건 CY 승
        dp[3] = true;
        dp[4] = true;

        for(int i=5; i <= N; i++) {
            // 1, 3, 4개 가져갔을 때 false 상태로 만들 수 있으면 SK가 이김
            if (!dp[i-1] || !dp[i-3] || !dp[i-4]) dp[i] = true;
            else dp[i] = false;
        }

        System.out.println(dp[N] ? "SK" : "CY");

        br.close();
    }
}
