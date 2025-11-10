import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[][] dp = new int[N+1][M+1];
        dp[1][1] = 1;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(i == 1 && j == 1) continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        if(K == 0) System.out.println(dp[N][M]);
        else {  // (0, 0) -> (kx, ky) / (kx, ky) -> (N-1, M-1)
            int kx = (K - 1) / M + 1;
            int ky = (K - 1) % M + 1;

            int[][] dp2 = new int[N+1][M+1];
            dp2[kx][ky] = 1;

            for(int i=kx; i<=N; i++) {
                for(int j=ky; j<=M; j++) {
                    if(i == kx && j == ky) continue;
                    dp2[i][j] = dp2[i-1][j] + dp2[i][j-1];
                }
            }

            System.out.println(dp[kx][ky] * dp2[N][M]);
        }

        br.close();
    }
}