import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for(int i=1; i<N; i++) {
            if(arr[i] >= arr[i-1]) dp[i] = dp[i-1] + 1;
        }
        int upMax = Arrays.stream(dp).max().getAsInt();

        dp = new int[N];
        Arrays.fill(dp, 1);
        for(int i=1; i<N; i++) {
            if(arr[i] <= arr[i-1]) dp[i] = dp[i-1] + 1;
        }
        int downMax = Arrays.stream(dp).max().getAsInt();

        System.out.println(Math.max(upMax, downMax));

        br.close();
    }
}