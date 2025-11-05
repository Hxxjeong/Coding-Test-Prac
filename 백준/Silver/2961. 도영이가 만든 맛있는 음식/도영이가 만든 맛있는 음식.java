import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long answer = Long.MAX_VALUE;
    static long[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new long[N][2];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Long.parseLong(input[0]);
            arr[i][1] = Long.parseLong(input[1]);
        }

        dfs(0, 1, 0, 0);    // 신맛 = 곱
        System.out.println(answer);

        br.close();
    }

    static void dfs(int idx, long sour, long bitter, int count) {
        if(idx == N) {
            if(count > 0) answer = Math.min(answer, Math.abs(sour-bitter));
            return;
        }

        // 현재 재료 선택
        dfs(idx+1, sour*arr[idx][0], bitter+arr[idx][1], count+1);

        // 현재 재료 선택하지 않음
        dfs(idx+1, sour, bitter, count);
    }
}
