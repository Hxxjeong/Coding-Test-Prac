import java.io.*;

public class Main {
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N+1];
        int[] result = new int[M];

        dfs(result, 0);
        br.close();
    }

    public static void dfs(int[] result, int depth) {
        // 깊이가 M에 도달하면 출력
        if (depth == M) {
            for (int num: result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i=1; i<=N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(result, depth+1);  // 다음 깊이로 탐색
                visited[i] = false;
            }
        }
    }
}