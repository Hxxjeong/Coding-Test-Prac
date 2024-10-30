import java.io.*;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(input[i]);

        visited = new boolean[N];
        int[] result = new int[N];
        dfs(result, arr, 0);

        System.out.println(max);

        br.close();
    }

    public static void dfs(int[] result, int[] arr, int depth) {
        if(depth == N) {
            max = Math.max(max, calculate(result));     // 주어진 식에 대해 최댓값 비교
            return;
        }

        // 순열 계산
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                dfs(result, arr, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int calculate(int[] result) {
        int sum = 0;
        for(int i=0; i<N-1; i++) {
            sum += Math.abs(result[i] - result[i+1]);
        }

        return sum;
    }
}