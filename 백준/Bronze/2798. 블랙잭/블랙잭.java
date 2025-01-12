import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(input[i]);

        Arrays.sort(arr);

        dfs(0, 0, 0);
        System.out.println(answer);

        br.close();
    }

    static void dfs(int depth, int start, int sum) {
        if(depth == 3) {
            if(sum <= M) answer = Math.max(answer, sum);
            return;
        }

        for(int i=start; i<N; i++) dfs(depth+1, i+1, sum+arr[i]);
    }
}
