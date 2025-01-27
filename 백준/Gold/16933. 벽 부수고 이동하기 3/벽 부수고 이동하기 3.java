import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M, K;
    static int[][] arr;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException{
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
        visited[0][0][0] = true;
        queue.add(new int[]{0, 0, 1, 0, 1});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dir = cur[2];
            int k = cur[3];
            int day = cur[4];   // 1: 낮, 0: 밤

            if(x == N-1 && y == M-1) return dir;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 벽을 뚫는 경우
                if(arr[nx][ny] == 1 && k < K && !visited[nx][ny][k+1]) {
                    // 낮에만 벽 뚫기
                    if(day == 1) {
                        visited[nx][ny][k+1] = true;
                        queue.add(new int[]{nx, ny, dir+1, k+1, 0});
                    }
                    // 밤에는 머무름
                    else queue.add(new int[]{x, y, dir+1, k, 1});
                }

                // 벽을 뚫지 않는 경우
                if(arr[nx][ny] == 0 && !visited[nx][ny][k]) {
                    visited[nx][ny][k] = true;
                    queue.add(new int[]{nx, ny, dir+1, k, 1-day});  // 밤낮 바꾸기
                }
            }
        }

        return -1;
    }
}
