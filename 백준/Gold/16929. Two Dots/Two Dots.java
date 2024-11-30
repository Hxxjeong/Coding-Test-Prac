import java.io.*;

public class Main {
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new char[N][M];
        for(int i=0; i<N; i++) arr[i] = br.readLine().toCharArray();

        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j]) {
                    if (dfs(i, j, i, j, 1)) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }

        System.out.println("No");

        br.close();
    }

    public static boolean dfs(int x, int y, int startX, int startY, int depth) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            // 시작점으로 돌아왔고, 깊이가 4 이상인 경우
            if(nx == startX && ny == startY && depth >= 4) return true;

            if(!visited[nx][ny] && arr[nx][ny] == arr[x][y] && dfs(nx, ny, startX, startY, depth+1)) return true;
        }

        visited[x][y] = false;
        return false;
    }
}
