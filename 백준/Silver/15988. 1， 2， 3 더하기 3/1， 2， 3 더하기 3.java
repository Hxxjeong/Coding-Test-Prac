import java.io.*;

public class Main {
    static long[] dp = new long[1_000_001];
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<dp.length; i++)
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }

        br.close();
    }
}