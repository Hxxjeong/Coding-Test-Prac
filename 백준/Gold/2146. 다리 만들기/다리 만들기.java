import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        visited = new boolean[N][N];
        int land = 2;

        // 섬 구분 및 각 섬의 경계점 판단
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                    land++;
                }
            }
        }

        // 구역에서 구역까지 다리 놓기
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] >= 2) { // 섬인 곳에서만 다리 놓기
                    findBridge(i, j);
                }
            }
        }

        System.out.println(min);

        br.close();
    }

    public static void bfs(int x, int y, int land) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        arr[x][y] = land;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || arr[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                arr[nx][ny] = land;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    public static void findBridge(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];

        queue.add(new int[]{x, y, 0});
        visit[x][y] = true;
        int from = arr[x][y];   // 출발하는 섬

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int distance = cur[2];

            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                // 경계거나 출발한 섬인 경우
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || arr[nx][ny] == from) continue;

                // 바다인 경우
                if(arr[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cur[2]+1});
                }
                // 다른 섬에 도달한 경우
                else if(arr[nx][ny] != from) {
                    min = Math.min(min, cur[2]);
                    return;
                }
            }
        }
    }
}