import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;

    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};   // 열
    static int[] dy = {0, 1, 0, -1};    // 행

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 세로
        int m = Integer.parseInt(input[1]); // 가로

        // 그래프 정의
        int[][] graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }

        int count = 0;  // 그림의 수
        int max = 0;    // 가장 넓은 그림

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(graph[i][j] == 0 || visited[i][j]) continue;

                count++;
                Queue<int[]> queue = new LinkedList<>();
                visited[i][j] = true;
                queue.offer(new int[]{i, j});   // 그래프의 좌표 위치

                int area = 0;   // 그림의 넓이
                while(!queue.isEmpty()) {
                    area++; // bfs를 할 때마다 넓이 1 증가

                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];

                    // 상하좌우 확인
                    for(int k=0; k<4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];

                        // 범위를 벗어나지 않으면서 색칠이 되어 있을 떄
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && graph[nx][ny] == 1) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }

                max = Math.max(max, area);  // 더 넓은 영역으로 갱신
            }
        }

        System.out.println(count);
        System.out.println(max);

        br.close();
    }
}