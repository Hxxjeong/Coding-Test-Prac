import java.io.*;

public class Main {
    static final int MOD = 1_000_000_009;
    static long[][] dp = new long[100001][4];   // n의 범위 & 1~3 (0번 인덱스 사용 X)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 같은 숫자가 연속으로 나오지 않기 위해 세 가지 케이스 필요
        // 1. 1로 끝나는 경우
        // 2. 2로 끝나는 경우
        // 3. 3으로 끝나는 경우
        dp[1][1] = 1;  // 1을 1로 끝내는 경우
        dp[2][2] = 1;  // 2를 2로 끝내는 경우
        dp[3][1] = 1;  // 3을 1로 끝내는 경우
        dp[3][2] = 1;  // 3을 2로 끝내는 경우
        dp[3][3] = 1;  // 3을 3으로 끝내는 경우

        for (int i=4; i<dp.length; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;  // i를 1로 끝내는 조합의 경우
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;  // i를 2로 끝내는 조합의 경우
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;  // i를 3으로 끝내는 조합의 경우
        }

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            long answer = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            System.out.println(answer);
        }

        br.close();
    }
}