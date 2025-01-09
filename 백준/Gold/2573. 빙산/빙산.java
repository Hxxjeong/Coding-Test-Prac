import java.io.*;
import java.util.*;

public class Main {
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        int day = 0;
        while(true) {
            int count = countIce();     // 덩어리 수

            if(count == 0) {
                System.out.println(0);
                break;
            }
            else if(count >= 2) {
                System.out.println(day);
                break;
            }

            melt();     // 빙산 녹이기
            day++;
        }

        br.close();
    }

    public static int countIce() {
        boolean[][] visited = new boolean[N][M];
        int count = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public static void bfs(int i, int j, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for(int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || arr[nx][ny] == 0) continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    public static void melt() {
        int[][] melt = new int[N][M];

        // 녹는 양 계산
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0) continue;

                for(int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0) melt[i][j]++;
                }
            }
        }

        // 빙산 업데이트
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                arr[i][j] = Math.max(0, arr[i][j] - melt[i][j]);    // 음수가 되는 것 대비
            }
        }
    }
}
