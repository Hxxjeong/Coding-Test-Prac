import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(input[i]);

        int[] dp = new int[N+1];
        dp[1] = arr[0];
        for(int i=2; i<=N; i++) dp[i] = arr[i-1] + dp[i-1];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            sb.append(dp[end]-dp[start-1]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
