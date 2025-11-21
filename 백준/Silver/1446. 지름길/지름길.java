import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int D = Integer.parseInt(input[1]);

        int[] dp = new int[D+1];
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0; i<=D; i++) {
            dp[i] = Integer.MAX_VALUE;
            list.add(new ArrayList<>());
        }

        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int len = Integer.parseInt(input[2]);

            if(end <= D && len < (end-start)) list.get(end).add(new int[]{start, len});
        }

        dp[0] = 0;
        for(int i=1; i<=D; i++) {
            dp[i] = dp[i-1] + 1;    // 기본 도로

            // i로 끝나는 지름길 적용
            for(int[] s: list.get(i)) {
                int start = s[0];
                int len = s[1];
                dp[i] = Math.min(dp[i], dp[start]+len);
            }
        }

        System.out.println(dp[D]);

        br.close();
    }
}