import java.io.*;
import java.util.*;

public class Main {
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        for (int i=0; i<T; i++) {
            String input = br.readLine();  // 배추밭
            StringTokenizer st = new StringTokenizer(input);
            int M = Integer.parseInt(st.nextToken());   // 가로 길이
            int N = Integer.parseInt(st.nextToken());   // 세로 길이
            int K = Integer.parseInt(st.nextToken());   // 배추가 심어져 있는 위치의 개수

            int[][] graph = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            // 배추 심기
            for (int j=0; j<K; j++) {
                String plant = br.readLine();
                StringTokenizer st2 = new StringTokenizer(plant);
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                graph[y][x] = 1;
            }

            int count = 0;
            for (int j=0; j<N; j++) {
                for (int k=0; k<M; k++) {
                    if (graph[j][k] == 1 && !visited[j][k]) {
                        bfs(graph, visited, j, k, N, M);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

        br.close();
    }

    private static void bfs(int[][] graph, boolean[][] visited, int j, int k, int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{j, k});
        visited[j][k] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 배추가 범위 내에 있고 방문하지 않은 경우
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}