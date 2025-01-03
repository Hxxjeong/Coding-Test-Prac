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
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            input = br.readLine().split("");
            for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        System.out.println(bfs());

        br.close();
    }

    public static int bfs() {
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] cost = new int[N][M];   // 최소 비용
        for (int i = 0; i < N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);

        deque.addFirst(new int[]{0, 0});
        cost[0][0] = 0;

        while(!deque.isEmpty()) {
            int[] cur = deque.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 벽을 부수는 경우
                if(arr[nx][ny] == 1 && cost[nx][ny] > cost[x][y]+1) {
                    cost[nx][ny] = cost[x][y]+1;
                    deque.addLast(new int[]{nx, ny});
                }

                // 벽이 없는 경우
                if(arr[nx][ny] == 0 && cost[nx][ny] > cost[x][y]) {
                    cost[nx][ny] = cost[x][y];
                    deque.addFirst(new int[]{nx, ny});
                }
            }
        }

        return cost[N-1][M-1];
    }
}
