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
        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split("");
            for(int j=0; j<N; j++) arr[i][j] = Integer.parseInt(str[j]);
        }

        List<Integer> list = new ArrayList<>();
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    list.add(dfs(i, j));
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        list.stream().forEach(System.out::println);

        br.close();
    }

    public static int dfs(int x, int y) {
        int count = 1;  // 현재 단지부터 시작
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && arr[nx][ny] == 1) {
                count += dfs(nx, ny);   // 연결된 단지 개수
            }
        }

        return count;
    }
}