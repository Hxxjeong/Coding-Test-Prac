import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M, K;
    static int[][] arr;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            input = br.readLine().split("");
            for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        visited = new boolean[N][M][K+1];
        System.out.println(bfs());

        br.close();
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dir = cur[2];
            int k = cur[3];

            if(x == N-1 && y == M-1) return dir;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 벽을 부수고 이동
                if (arr[nx][ny] == 1 && k < K && !visited[nx][ny][k+1]) {
                    queue.add(new int[]{nx, ny, dir+1, k+1});
                    visited[nx][ny][k+1] = true;
                }

                // 벽을 부수지 않고 이동
                if (arr[nx][ny] == 0 && !visited[nx][ny][k]) {
                    queue.add(new int[]{nx, ny, dir+1, k});
                    visited[nx][ny][k] = true;
                }
            }
        }

        return -1;
    }
}
