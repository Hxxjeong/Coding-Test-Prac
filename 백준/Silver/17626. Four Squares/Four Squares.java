import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);    // i를 이루는 j^2를 뺀 값에서 +1
            }
        }

        System.out.println(dp[n]);

        br.close();
    }
}