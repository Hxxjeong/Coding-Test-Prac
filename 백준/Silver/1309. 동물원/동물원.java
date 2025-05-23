import java.io.*;

public class Main {
    static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][3];
        dp[1][0] = 1;   // 첫 줄에 사자를 넣지 않는 경우
        dp[1][1] = 1;   // 첫 줄에 사자를 왼쪽에 넣는 경우
        dp[1][2] = 1;   // 첫 줄에 사자를 오른쪽에 넣는 경우

        for(int i=2; i<=N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;    // 배치하지 않으면 이전 줄과 상관 없음
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;     // 왼쪽에 넣을 경우 이전 줄에 없거나 오른쪽에 위치
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;     // 오른쪽에 넣을 경우 이전 줄에 없거나 왼쪽에 위치
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % MOD);

        br.close();
    }
}