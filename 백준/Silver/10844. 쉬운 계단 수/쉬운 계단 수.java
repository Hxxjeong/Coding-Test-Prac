import java.io.*;

public class Main {
    static final int MOD = 1_000_000_000;
    static long[][] dp = new long[101][10];     // n의 범위 & 자릿수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 수의 길이

        // 길이가 1일 때 계단 수
        for(int i=1; i<=9; i++)  dp[1][i] = 1;

        // ex) n=3, 끝자리=4일 때, 길이가 2인 끝자리가 3, 5를 확인해야 함
        // 끝자리가 0이라면 1만, 끝자리가 9라면 8만 확인
        for (int i=2; i<=N; i++) {
            for (int j=0; j<=9; j++) {
                // 끝자리(j)가 1~9인 경우
                if (j > 0)
                    dp[i][j] += dp[i-1][j-1] % MOD;  // 이전 자릿수에서 j-1

                // 0~8인 경우
                if (j < 9)
                    dp[i][j] += dp[i-1][j+1] % MOD;  // 이전 자릿수에서 j+1

                dp[i][j] %= MOD;    // 문제 조건
            }
        }

        long answer = 0;
        for (int i=0; i<=9; i++)
            answer += dp[N][i];     // 계단 수 합산

        System.out.println(answer % MOD);

        br.close();
    }
}