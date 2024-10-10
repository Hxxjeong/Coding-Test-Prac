import java.io.*;

public class Main {
    static long[][] dp = new long[91][2];     // n의 범위 & 자릿수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 수의 길이

        dp[1][0] = 0;   // 길이가 1이면서 0으로 끝나는 경우
        dp[1][1] = 1;   // 길이가 1이면서 1로 끝나는 경우
        dp[2][0] = 1;   // 길이가 2면서 0으로 끝나는 경우
        dp[2][1] = 0;   // 길이가 2면서 1로 끝나는 경우

        // 1로 끝날 때 그 앞자리의 수가 1이 아니면 됨
        for(int i=3; i<=N; i++) {
            dp[i][0] = dp[i-1][1] + dp[i-1][0];  // 0으로 끝날 때 앞자리 아무거나 ok
            dp[i][1] = dp[i-1][0]; // 1로 끝날 때 앞자리 0이어야 함
        }

        System.out.println(dp[N][0] + dp[N][1]);

        br.close();
    }
}