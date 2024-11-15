import java.io.*;
import java.util.*;

public class Main {
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        int maxHeight = 0;
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        int answer = 0;
        // 최대 높이까지 잠기는 정도에 따라 안전지대 갱신
        for(int height=0; height<maxHeight; height++) {
            visited = new boolean[N][N];
            int safe = 0;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    // 잠기지 않은 안전한 지대이고 아직 방문하지 않은 경우
                    if(arr[i][j] > height && !visited[i][j]) {
                        bfs(i, j, height);
                        safe++;  // 새로운 안전지대 발견 시 개수 증가
                    }
                }
            }

            answer = Math.max(answer, safe);
        }

        System.out.println(answer);

        br.close();
    }

    public static void bfs(int x, int y, int height) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                // 경계 안이고, 잠기지 않은 경우 탐색
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] > height && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}