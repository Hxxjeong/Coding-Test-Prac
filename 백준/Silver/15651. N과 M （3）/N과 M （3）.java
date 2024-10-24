import java.io.*;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[] result = new int[M];

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

        for (int i=1; i<=N; i++) {
            result[depth] = i;
            dfs(result, depth+1);
        }
    }
}