import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]); // 시작 볼륨
        int M = Integer.parseInt(input[2]);

        int[] diff = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean[][] dp = new boolean[N+1][M+1]; // i번째 곡을 연주할 때 볼륨 j 가능
        dp[0][S] = true;
        for(int i=1; i<=N; i++) {
            for(int j=0; j<=M; j++) {
                if(dp[i-1][j]) { // 이전 곡의 가능한 볼륨인 경우
                    if(j + diff[i-1] <= M) dp[i][j+diff[i-1]] = true;
                    if(j - diff[i-1] >= 0) dp[i][j-diff[i-1]] = true;
                }
            }
        }

        int answer = -1;
        for(int i=M; i>=0; i--) {
            if(dp[N][i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);


        br.close();
    }
}