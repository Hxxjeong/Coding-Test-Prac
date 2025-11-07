import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new char[N][M];
        int startX = 0;
        int startY = 0;
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                if(line.charAt(j) == 'I') {
                    startX = i;
                    startY = j;
                }
                arr[i][j] = line.charAt(j);
            }
        }

        int answer = bfs(startX, startY);
        System.out.println(answer == 0 ? "TT" : answer);

        br.close();
    }

    public static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        boolean[][] visited = new boolean[N][M];
        visited[startX][startY] = true;

        int person = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || arr[nx][ny] == 'X') continue;

                if(arr[nx][ny] == 'P') person++;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

        return person;
    }
}
