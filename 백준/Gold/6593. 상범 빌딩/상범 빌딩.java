import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static int L, R, C, time;
    static char[][][] arr;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        StringBuilder sb = new StringBuilder();
        while(!(input = br.readLine()).equals("0 0 0")) {
            String[] s = input.split(" ");
            L = Integer.parseInt(s[0]);     // 층
            R = Integer.parseInt(s[1]);     // 행
            C = Integer.parseInt(s[2]);     // 열

            arr = new char[L][R][C];
            int startX = 0, startY = 0, startZ = 0;
            for(int i=0; i<L; i++) {
                for(int j=0; j<R; j++) {
                    String line = br.readLine();
                    for(int k=0; k<C; k++) {
                        arr[i][j][k] = line.charAt(k);
                        if (arr[i][j][k] == 'S') {
                            startX = i;
                            startY = j;
                            startZ = k;
                        }
                    }
                }
                br.readLine();
            }

            visited = new boolean[L][R][C];
            time = bfs(startX, startY, startZ);

            sb.append(time == -1 ? "Trapped!" : "Escaped in "+ time + " minute(s).").append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static int bfs(int i, int j, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j, k, 0});
        visited[i][j][k] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int z = cur[2];
            int t = cur[3];

            for(int c=0; c<6; c++) {
                int nx = x + dx[c];
                int ny = y + dy[c];
                int nz = z + dz[c];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= L || ny >= R || nz >= C) continue;
                if (visited[nx][ny][nz] || arr[nx][ny][nz] == '#') continue;

                if(arr[nx][ny][nz] == 'E') return t+1;

                queue.add(new int[]{nx, ny, nz, t+1});
                visited[nx][ny][nz] = true;
            }
        }

        return -1;
    }
}
