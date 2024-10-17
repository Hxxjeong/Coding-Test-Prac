import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N+1];   // 0번 인덱스 사용 X
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(input[i-1]);

        int[] dp = new int[N+1];
        Arrays.fill(dp, 1);

        for(int i=2; i<=N; i++) {
            for(int j=1; j<i; j++) {
                if(arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);   // 본인 전의 인덱스를 살피면서 LDS 갱신
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

        br.close();
    }
}