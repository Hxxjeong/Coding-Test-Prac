import java.io.*;
import java.util.*;

public class Main {
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        char[][] graph = new char[R][C];
        int[][] fireDist = new int[R][C];
        int[][] jihoonDist = new int[R][C];

        // 그래프와 거리 초기화
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = str.charAt(j);
                fireDist[i][j] = -1;
                jihoonDist[i][j] = -1;
            }
        }

        Queue<int[]> fireQueue = new LinkedList<>();
        Queue<int[]> jihoonQueue = new LinkedList<>();

        // 초기 위치를 큐에 추가
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 'F') {
                    fireQueue.add(new int[]{i, j});
                    fireDist[i][j] = 0;
                }
                if (graph[i][j] == 'J') {
                    jihoonQueue.add(new int[]{i, j});
                    jihoonDist[i][j] = 0;
                }
            }
        }

        // 불의 BFS
        while (!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (fireDist[nx][ny] >= 0 || graph[nx][ny] == '#') continue;    // 이미 방문했거나 벽인 경우

                fireDist[nx][ny] = fireDist[x][y] + 1;
                fireQueue.add(new int[]{nx, ny});
            }
        }

        // 지훈이의 BFS
        while (!jihoonQueue.isEmpty()) {
            int[] cur = jihoonQueue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 탈출한 경우
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    System.out.println(jihoonDist[x][y] + 1);
                    return;
                }
                
                // 벽이거나 불보다 나중에 도착하는 경우 continue
                if (jihoonDist[nx][ny] >= 0 || graph[nx][ny] == '#') continue;
                if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= jihoonDist[x][y] + 1) continue;

                jihoonDist[nx][ny] = jihoonDist[x][y] + 1;
                jihoonQueue.add(new int[]{nx, ny});
            }
        }

        System.out.println("IMPOSSIBLE");

        br.close();
    }
}