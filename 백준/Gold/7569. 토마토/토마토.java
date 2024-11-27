import java.io.*;
import java.util.*;

public class Main {
    // 여섯 가지 방향
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};
    static int[] dz = {-1, 1, 0, 0, 0, 0};

    static int N, M, L; // 가로, 세로, 높이
    static int[][][] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 가로
        M = Integer.parseInt(input[1]); // 세로
        L = Integer.parseInt(input[2]); // 높이

        arr = new int[L][M][N];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<L; i++) {
            for(int j=0; j<M; j++) {
                String[] row = br.readLine().split(" ");
                for(int k=0; k<N; k++) {
                    arr[i][j][k] = Integer.parseInt(row[k]);
                    if (arr[i][j][k] == 1) queue.add(new int[]{i, j, k});
                }
            }
        }

        System.out.println(bfs(queue));

        br.close();
    }

    public static int bfs(Queue<int[]> queue) {
        int day = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] cur = queue.poll();

                for(int j=0; j<6; j++) {
                    int nz = cur[0] + dz[j];
                    int ny = cur[1] + dy[j];
                    int nx = cur[2] + dx[j];

                    if (nz < 0 || ny < 0 || nx < 0 || nz >= L || ny >= M || nx >= N || arr[nz][ny][nx] != 0) continue;

                    arr[nz][ny][nx] = 1;
                    queue.add(new int[]{nz, ny, nx});
                }
            }
            day++;
        }

        // 익지 못한 토마토 확인
        for(int i=0; i<L; i++) {
            for(int j=0; j<M; j++) {
                for(int k=0; k<N; k++) {
                    if(arr[i][j][k] == 0) return -1;
                }
            }
        }

        return day;
    }
}
