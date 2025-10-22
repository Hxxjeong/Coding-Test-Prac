import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0; i<N; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue; // 갈 수 없는 칸

            for(int j=1; j<=arr[i]; j++) { // 점프 가능한 거리
                if(i+j < N) dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }

        System.out.println(dp[N-1] == Integer.MAX_VALUE ? -1 : dp[N-1]);

        br.close();
    }
}