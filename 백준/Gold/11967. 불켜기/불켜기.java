import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M;
    static boolean[][] visited;
    static boolean[][] lighted;
    static List<int[]>[][] list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        list = new ArrayList[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) list[i][j] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int a = Integer.parseInt(input[2]);
            int b = Integer.parseInt(input[3]);
            list[x][y].add(new int[]{a, b});
        }

        lighted = new boolean[N+1][N+1];
        lighted[1][1] = true;

        System.out.println(bfs());

        br.close();
    }

    public static int bfs() {
        int count = 1;
        boolean changed;

        do {
            changed = false;    // 꺼진 방 -> 켜진 방 확인
            visited = new boolean[N+1][N+1];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{1, 1});
            visited[1][1] = true;

            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                // 스위치로 불 켜기
                for(int[] i: list[x][y]) {
                    int nx = i[0];
                    int ny = i[1];

                    // 불이 꺼진 경우 켜기
                    if(!lighted[nx][ny]) {
                        lighted[nx][ny] = true;
                        count++;
                        changed = true;
                    }
                }

                // 현재 방에서 이동 가능한 방 탐색
                for(int i=0; i<4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 1 || ny < 1 || nx > N || ny > N || visited[nx][ny] || !lighted[nx][ny]) continue;

                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        } while(changed);

        return count;
    }
}