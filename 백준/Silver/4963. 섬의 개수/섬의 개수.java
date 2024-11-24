import java.io.*;

public class Main {
    // 11시 방향부터 시계방향
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int w, h;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while(!(input = br.readLine()).equals("0 0")) {
            w = Integer.parseInt(input.split(" ")[0]);  // 가로
            h = Integer.parseInt(input.split(" ")[1]);  // 세로

            arr = new int[h][w];

            // 양방향 그래프
            for(int i=0; i<h; i++) {
                String[] str = br.readLine().split(" ");
                for(int j=0; j<w; j++) arr[i][j] = Integer.parseInt(str[j]);
            }

            visited = new boolean[h][w];
            int answer = 0;
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(!visited[i][j] && arr[i][j] == 1) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }

        br.close();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny] && arr[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}