import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n+1];
        for(int i=1; i<=n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }

        int[] dp = new int[n+1];
        dp[1] = stairs[1];
        dp[2] = stairs[2] + stairs[1];

        // 마지막 계단을 밟는 경우 2가지
        // 1. i-1을 밟으면서 가는 경우
        // 2. i-1를 건너뛰고 i-2를 밟으면서 가는 경우
        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i]);
        }

        System.out.println(dp[n]);

        br.close();
    }
}