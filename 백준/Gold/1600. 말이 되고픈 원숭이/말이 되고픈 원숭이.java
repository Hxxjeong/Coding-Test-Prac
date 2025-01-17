import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // 말
    static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};

    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int K, W, H;
    static int[][] arr;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        W = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[1]);

        arr = new int[H][W];
        for(int i=0; i<H; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<W; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        visited = new boolean[H][W][K+1];   // 말의 움직임까지 포함
        System.out.println(bfs());

        br.close();
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int k = cur[2];
            int dir = cur[3];

            if(x == H-1 && y == W-1) return dir;

            if(k < K) {
                for(int i=0; i<8; i++) {
                    int nx = x + hx[i];
                    int ny = y + hy[i];

                    if(nx < 0 || ny < 0 || nx >= H || ny >= W || visited[nx][ny][k+1] || arr[nx][ny] == 1) continue;

                    queue.add(new int[]{nx, ny, k+1, dir+1});
                    visited[nx][ny][k+1] = true;
                }
            }

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= H || ny >= W || visited[nx][ny][k] || arr[nx][ny] == 1) continue;

                queue.add(new int[]{nx, ny, k, dir+1});
                visited[nx][ny][k] = true;
            }
        }

        return -1;
    }
}
