import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(input[i]);

        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++) dp[i] = arr[i-1] + dp[i-1];

        int max = Integer.MIN_VALUE;
        for(int i=K; i<=N; i++) max = Math.max(max, dp[i] - dp[i-K]);

        System.out.println(max);

        br.close();
    }
}
