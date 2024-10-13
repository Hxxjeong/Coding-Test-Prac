import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];    // 제곱수 합으로 나타날 떄의 최소 항의 개수
        dp[1] = 1;

        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + 1;    // 배열 초기화 ((i-1)을 제곱수로 표현한 뒤 1을 더한 값)
            for(int j=2; j<(int) Math.sqrt(i)+1; j++) { // i에서 뺴려는 제곱수 j의 크기를 비교하여 최소 항의 개수 찾기
                dp[i] = Math.min(dp[i], dp[i-(j*j)] + 1);   // 현재 값과 j^2를 뺀 값에서 1을 더할 때와 비교
            }
        }

        System.out.println(dp[N]);

        br.close();
    }
}