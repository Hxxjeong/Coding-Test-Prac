import java.io.*;
import java.util.*;

public class Main {
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M;
    static int[][] arr;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            input = br.readLine().split("");
            for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        System.out.println(bfs());

        br.close();
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});
        visited = new boolean[N][M][2];     // arr 배열 + 벽을 부쉈는지 여부
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int answer = cur[2];
            int brokeWall = cur[3];

            if(x == N-1 && y == M-1) return answer;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 벽을 부수지 않고 이동
                if(arr[nx][ny] == 0 && !visited[nx][ny][brokeWall]) {
                    queue.add(new int[]{nx, ny, answer+1, brokeWall});
                    visited[nx][ny][brokeWall] = true;
                }

                // 벽을 부수고 이동
                if(arr[nx][ny] == 1 && brokeWall == 0 && !visited[nx][ny][1]) {
                    queue.add(new int[]{nx, ny, answer+1, 1});
                    visited[nx][ny][1] = true;
                }
            }
        }

        return -1;
    }
}
