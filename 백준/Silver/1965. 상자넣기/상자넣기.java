import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 자기 자신만 포함하는 경우
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

        br.close();
    }
}