import java.io.*;

public class Main {
    static int[][] dp = new int[201][201];
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        /*
        [n=1, k=1] = 1 (1개)
        [n=1, k=2] = 1+0, 0+1 (2개) = [n=1, k=1] + 1
        [n=1, k=3] = 1+0+0, 0+1+0, 0+0+1 (3개) = [n=1, k=2] + 1
        ....
        [n=1, k=N] = [n=1, k=N-1] + 1

        [n=2, k=1] = 2 (1개)
        [n=2, k=2] = 0+2, 2+0, 1+1 (3개) = [n=0, k=1] + [n=1, k=1] + [n=2, k=1]
        [n=2, k=3] = [n=2, k=2] (0+2+0, 2+0+0, 1+1+0) + [n=1, k=2] (1+0+1, 0+1+1) + [n=0, k=2] (0+0+2) + 1 (2+0+0) = 7
        [n=2, k=4] = [n=0, k=3] + [n=1, k=3] + [n=2, k=3] + 1

        [n=6, k=1] = 6
        [n=6, k=2] = [n=6, k=1] + [n=5, k=1] + [n=4, k=1] + 1

        앞선 자연수에 대해 0을 붙이는 경우, 1을 붙이는 경우, ..., n을 붙이는 경우
        [n, k] = [n=n, k=k-1] + [n=n-1, k=k-1] + [n=n-2, k=k-1] + ... + [n=0, k=k-1] + 1
         */

        dp[0][K] = 1;   // 0을 K개만큼 더하는 개수

        for(int i=1; i<=N; i++) {
            dp[i][1] = 1;   // 어떤 수가 항이 1개만 있는 경우는 1
            for(int j=2; j<=K; j++) {
                dp[i][j] = 1;   // 마지막에 더하는 1
                for(int k=0; k<=i; k++) {
                    dp[i][j] += dp[i-k][j-1];
                    dp[i][j] %= MOD;
                }
            }
        }

        System.out.println(dp[N][K]);

        br.close();
    }
}