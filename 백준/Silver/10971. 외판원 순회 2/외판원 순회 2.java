import java.io.*;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] cost;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 도시의 수

        cost = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) cost[i][j] = Integer.parseInt(input[j]);
        }

        visited = new boolean[N];
        dfs(0, 0, 0, 0);    // 시작점부터 탐색

        System.out.println(min);

        br.close();
    }

    public static void dfs(int start, int depth, int current, int sum) {
        // 모든 도시를 순회하고 시작점으로 돌아온 경우 최솟값 갱신
        if (depth == N && current == start) {
            min = Math.min(min, sum);
            return;
        }

        for (int next=0; next<N; next++) {
            if (!visited[next] && cost[current][next] > 0) {  // 방문하지 않은 도시로 이동
                visited[next] = true;
                dfs(start, depth+1, next, sum + cost[current][next]);
                visited[next] = false;
            }
        }
    }
}