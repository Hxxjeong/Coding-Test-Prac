import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        String[] nums = br.readLine().split(" ");
        arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(nums[i]);
        Arrays.sort(arr);

        int[] result = new int[M];
        visited = new boolean[N+1];

        dfs(result, 0);
        System.out.println(sb);

        br.close();
    }

    public static void dfs(int[] result, int depth) {
        // 깊이가 M에 도달하면 출력
        if (depth == M) {
            for (int num: result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                dfs(result, depth+1);
                visited[i] = false;
            }
        }
    }
}