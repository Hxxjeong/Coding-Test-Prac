import java.io.*;
import java.util.*;

public class Main {
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            input = br.readLine().split("");
            for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        visited = new boolean[N][M];
        System.out.println(bfs());

        br.close();
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});     // 시작점
        visited[0][0] = true;

        int[][] distance = new int[N][M];
        distance[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if(x == N-1 && y == M-1) return distance[x][y];

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || arr[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                distance[nx][ny] = distance[x][y] + 1;
                queue.add(new int[]{nx, ny});
            }
        }

        return -1;  // 도달할 수 없는 경우 (문제는 항상 도달함)
    }
}