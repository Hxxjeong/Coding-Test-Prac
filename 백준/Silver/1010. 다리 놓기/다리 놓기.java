import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            sb.append(combination(M, N)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    // mCn = m! / n!(m-n)!
    public static long combination(int m, int n) {
        long[][] dp = new long[m+1][n+1];

        for(int i=0; i<=m; i++) {
            dp[i][0] = 1; // 1C0 = 1

            for(int j=1; j<=Math.min(i, n); j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        return dp[m][n];
    }
}
