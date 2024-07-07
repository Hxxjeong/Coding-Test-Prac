import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;

    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};   // 열
    static int[] dy = {0, 1, 0, -1};    // 행

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] graph = new int[N][M];
        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split("");
            for(int j=0; j<M; j++) graph[i][j] = Integer.parseInt(str[j]);
        }

        visited = new boolean[N][M];

        int count = bfs(graph, N, M);
        System.out.println(count);

        br.close();
    }

    public static int bfs(int[][] graph, int N, int M) {
        // 초기 설정
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[][] distance = new int[N][M];   // (0, 0)에서부터의 각 좌표 거리 배열
        distance[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int k=0; k<4; k++) {
                int nx = dx[k] + x;
                int ny = dy[k] + y;

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    distance[nx][ny] = distance[x][y] + 1;  // 거리 계산 (이전 좌표에서 +1)
                }
            }
        }

        return distance[N-1][M-1];  // (n, m)까지의 최소 거리
    }
}