import java.io.*;
import java.util.*;

public class Main {
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int w, h;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);

            char[][] arr = new char[h][w];
            Queue<int[]> person = new LinkedList<>();
            Queue<int[]> fire = new LinkedList<>();
            for (int j=0; j<h; j++) {
                String map = br.readLine();
                for (int k=0; k<w; k++) {
                    arr[j][k] = map.charAt(k);
                    if (arr[j][k] == '@') person.add(new int[]{j, k});
                    if (arr[j][k] == '*') fire.add(new int[]{j, k});
                }
            }

            int answer = bfs(arr, person, fire);
            sb.append(answer == -1 ? "IMPOSSIBLE" : answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static int bfs(char[][] arr, Queue<int[]> person, Queue<int[]> fire) {
        int count = 0;

        while(!person.isEmpty()) {
            // 불 먼저 확산
            int fireSize = fire.size();
            for(int i=0; i<fireSize; i++) {
                int[] cur = fire.poll();

                for(int j=0; j<4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    // 경계를 벗어나거나 빈공간이 아닌 경우
                    if(nx < 0 || ny < 0 || nx >= h || ny >= w || arr[nx][ny] != '.') continue;
                    
                    arr[nx][ny] = '*';
                    fire.add(new int[]{nx, ny});
                }
            }

            // 사람 이동
            int personSize = person.size();
            for(int i=0; i<personSize; i++) {
                int[] cur = person.poll();

                for(int j=0; j<4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    // 탈출했을 경우
                    if(nx < 0 || ny < 0 || nx >= h || ny >= w) return count+1;

                    // 빈 공간만 이동 가능
                    if(arr[nx][ny] == '.') {
                        arr[nx][ny] = '@';
                        person.add(new int[]{nx, ny});
                    }
                }
            }

            count++;
        }

        return -1;  // 탈출하지 못한 경우
    }
}
