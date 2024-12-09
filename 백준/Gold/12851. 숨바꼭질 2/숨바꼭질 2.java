import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int count;
    static int min = Integer.MAX_VALUE;

    static int[] visited = new int[100_001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        Arrays.fill(visited, -1);
        bfs(N);

        System.out.println(min);
        System.out.println(count);

        br.close();
    }

    public static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});     // 위치, 시간
        visited[start] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int position = cur[0];
            int time = cur[1];

            if(position == K) {
                // 최소 시간 갱신인 경우 방법 초기화
                if(time < min) {
                    min = time;
                    count = 1;
                }
                // 최소 시간과 같은 경우 방법 갱신
                else if(time == min) count++;

                continue;
            }

            for(int i: new int[]{position+1, position-1, position*2}) {
                if(i < 0 || i > 100000) continue;

                // 아직 방문하지 않았거나 동일 시간에 방문하는 경우
                if(visited[i] == -1 || visited[i] == time+1) {
                    visited[i] = time+1;
                    queue.add(new int[]{i, time+1});
                }
            }
        }
    }
}
