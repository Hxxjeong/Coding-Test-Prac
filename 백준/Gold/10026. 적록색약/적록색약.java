import java.io.*;
import java.util.*;

public class Main {
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);

        arr = new char[N][N];
        for(int i=0; i<N; i++) {
            String grid = br.readLine();
            for(int j=0; j<N; j++) arr[i][j] = grid.charAt(j);
        }

        // 적록색약이 아닌 경우
        visited = new boolean[N][N];
        int area = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j]) continue;
                bfs(i, j);
                area++;
            }
        }
        System.out.print(area + " ");

        visited = new boolean[N][N];
        int blindArea = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 'R') arr[i][j] = 'G';
            }
        }

        // 적록색약인 경우
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j]) continue;
                bfs(i, j);
                blindArea++;
            }
        }
        System.out.println(blindArea);

        br.close();
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});     // 시작점
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || arr[nx][ny] != arr[x][y]) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}