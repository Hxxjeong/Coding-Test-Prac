import java.io.*;

public class Main {
    static long[][] dp = new long[1001][10];
    static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 한 자리인 오르막 수 초기화
        for(int i=0; i<10; i++) dp[1][i] = 1;

        for(int i=2; i<=N; i++) {
            for(int j=0; j<10; j++) {
                for(int k=0; k<=j; k++) {
                    dp[i][j] += dp[i-1][k];   // 이전 자릿수를 확인해서 자신보다 같거나 큰 값 추가
                    dp[i][k] %= MOD;
                }
            }
        }

        long answer = 0;
        for(int i=0; i<10; i++) {
            answer += dp[N][i];
            answer %= MOD;
        }

        System.out.println(answer);

        br.close();
    }
}