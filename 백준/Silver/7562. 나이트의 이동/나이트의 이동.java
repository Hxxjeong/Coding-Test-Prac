import java.io.*;
import java.util.*;

public class Main {
    // 이동 방향
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static int l;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            l = Integer.parseInt(br.readLine());

            arr = new int[l][l];
            String[] input = br.readLine().split(" ");
            int startX = Integer.parseInt(input[0]);
            int startY = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            int endX = Integer.parseInt(input[0]);
            int endY = Integer.parseInt(input[1]);

            visited = new boolean[l][l];
            sb.append(bfs(startX, startY, endX, endY)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static int bfs(int startX, int startY, int endX, int endY) {
        if (startX == endX && startY == endY) return 0; // 출발지와 목적지가 같은 경우

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i=0; i<8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                // 체스판 경계 내에 있고 방문하지 않은 경우만
                if(nx >= 0 && nx < l && ny >= 0 && ny < l && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    arr[nx][ny] = arr[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{nx, ny});

                    // 도달한 경우
                    if (nx == endX && ny == endY) return arr[nx][ny];
                }
            }
        }

        return -1;
    }
}
