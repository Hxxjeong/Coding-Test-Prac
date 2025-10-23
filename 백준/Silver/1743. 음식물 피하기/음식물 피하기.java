import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        arr = new int[N][M];
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<K; i++) {
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0])-1;
            int c = Integer.parseInt(input[1])-1;
            arr[r][c] = 1;
            list.add(new int[]{r, c});
        }

        int answer = 0;
        visited = new boolean[N][M];
        for(int i=0; i<K; i++) {
            int[] cur = list.get(i);
            int x = cur[0];
            int y = cur[1];

            if(arr[x][y] == 1 && !visited[x][y])
                answer = Math.max(answer, bfs(x, y));
        }

        System.out.println(answer);

        br.close();
    }

    private static int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new int[]{i, j});

        int size = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int r=0; r<4; r++) {
                int nx = x + dx[r];
                int ny = y + dy[r];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != 1 || visited[nx][ny]) continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                size++;
            }
        }

        return size;
    }
}