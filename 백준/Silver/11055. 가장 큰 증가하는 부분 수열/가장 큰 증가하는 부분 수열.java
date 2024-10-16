import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N+1];   // 0번 인덱스 사용 X
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(input[i-1]);

        int[] dp = Arrays.copyOf(arr, N+1);    // dp 초기화 (본인만 포함한다고 가정)

        for(int i=2; i<=N; i++) {
            for(int j=1; j<i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+arr[i]);  // 현재 본인까지의 LIS와 이전 LIS + 본인 중 더 큰 값 선택
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

        br.close();
    }
}