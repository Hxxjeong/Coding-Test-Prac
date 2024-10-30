import java.io.*;

public class Main {
    static int n;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        int[] result = new int[n];
        dfs(result, 0);

        System.out.println(sb);

        br.close();
    }

    public static void dfs(int[] result, int depth) {
        if(depth == n) {
            for(int num: result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(result, depth+1);
                visited[i] = false;
            }
        }
    }
}