import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;   // 시작 지점 초기화
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 이동이 불가한 경우
                if (arr[i][j] == 0 || dp[i][j] == 0) continue;

                int jump = arr[i][j];

                // 오른쪽으로 이동
                if(j + jump < N) dp[i][j+jump] += dp[i][j];    // arr[i][j+jump]까지 가는 방법 갱신

                // 아래쪽으로 이동
                if(i + jump < N) dp[i+jump][j] += dp[i][j];     // arr[i+jump][j]까지 가는 방법 갱신
            }
        }

        System.out.println(dp[N-1][N-1]);

        br.close();
    }
}