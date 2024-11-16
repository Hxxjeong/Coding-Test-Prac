import java.io.*;
import java.util.*;

public class Main {
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int M, N;
    static int[][] arr;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        arr = new int[M][N];

        // 직사각형 영역
        for (int i=0; i<K; i++) {
            String[] rac = br.readLine().split(" ");
            int x1 = Integer.parseInt(rac[0]);
            int y1 = Integer.parseInt(rac[1]);
            int x2 = Integer.parseInt(rac[2]);
            int y2 = Integer.parseInt(rac[3]);

            for (int j=y1; j<y2; j++) {
                for (int k=x1; k<x2; k++) arr[j][k] = -1;
            }
        }

        int answer = 0;
        visited = new boolean[M][N];
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] != -1 && !visited[i][j]) {
                    int area = bfs(i, j);
                    list.add(area);
                    answer++;
                }
            }
        }

        System.out.println(answer);

        Collections.sort(list);
        for(int i: list) System.out.print(i + " ");

        br.close();
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int area = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && arr[nx][ny] != -1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    area++;
                }
            }
        }

        return area;
    }
}