import java.io.*;
import java.util.*;

public class Main {
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};   // 열
    static int[] dy = {0, 1, 0, -1};    // 행

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]); // 가로
        int N = Integer.parseInt(input[1]); // 세로

        int[][] graph = new int[N][M];
        int[][] distance = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) queue.offer(new int[]{i, j});  // 익은 토마토면 큐에 추가

                if(graph[i][j] == 0) distance[i][j] = -1;   // 익지 않은 토마토
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int k=0; k<4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                // 범위를 벗어나지 않고 토마토가 익지 않은 경우
                if(nx >= 0 && nx < N && ny >=0 && ny < M && distance[nx][ny] < 0) {
                    distance[nx][ny] = distance[cur[0]][cur[1]] + 1;    // 다음 익은 토마토까지의 거리
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        int answer = 0;
        a:for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(distance[i][j] == -1) {  // 모두 익은 토마토가 아닌 경우
                    answer = -1;
                    break a;
                }
                answer = Math.max(answer, distance[i][j]);
            }
        }

        System.out.println(answer);

        br.close();
    }
}