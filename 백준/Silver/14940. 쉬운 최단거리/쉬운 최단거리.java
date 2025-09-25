import java.io.*;
import java.util.*;

public class Main {
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] arr = new int[n][m];
        int[][] answer = new int[n][m];
        for(int i=0; i<n; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                answer[i][j] = -1;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    answer[i][j] = 0;
                }
                if(arr[i][j] == 0) answer[i][j] = 0; // 갈 수 없는 땅
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == 0) continue;
                if(answer[nx][ny] != -1) continue; // 이미 방문한 곳

                answer[nx][ny] = answer[x][y] + 1;
                queue.add(new int[]{nx, ny});
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

        br.close();
    }
}