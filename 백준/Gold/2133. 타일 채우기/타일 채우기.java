import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 홀수일 때는 사각형을 채울 수 없음
        if(N % 2 != 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[2] = 3;

        // N을 2와 N-2로 나눈 경우, 4와 N-4로 나누는 경우, 6과 N-6을 나누는 경우, ..., 마지막에 특이 패턴 2개 추가
        // 4와 N-4로 나누는 방법부터는 중복을 생각해야 하고, dp[2]는 항상 3이므로 N-4에 특이 패턴을 곱한 값이 됨
        // dp[N] = (dp[N-2] * dp[2]) + (dp[N-4] * 2) + (dp[N-6] * 2) + (dp[N-8] * 2) + ... + (dp[0] * 2)
        for(int i=4; i<=N; i+=2) {
            dp[i] = dp[i-2] * 3;    // 기본 패턴 (여기서 곱하는 3은 dp[2])
            for(int j=4; j<=i; j+=2) {
                dp[i] += dp[i-j] * 2;  // 특이 패턴 추가
            }
        }

        System.out.println(dp[N]);

        br.close();
    }
}