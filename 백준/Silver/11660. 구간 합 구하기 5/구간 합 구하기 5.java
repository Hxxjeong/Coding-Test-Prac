import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            input = br.readLine().split(" ");
            for(int j=1; j<=N; j++) arr[i][j] = Integer.parseInt(input[j-1]);
        }

        int[][] dp = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                dp[i][j] = arr[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];  // 위쪽과 왼쪽의 값을 더하고, 중복된 dp[i-1][j-1]을 뺌
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            int answer = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
