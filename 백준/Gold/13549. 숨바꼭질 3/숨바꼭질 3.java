import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[] visited = new boolean[200_001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        System.out.println(bfs());

        br.close();
    }

    public static int bfs() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{N, 0});
        visited[N] = true;

        while(!deque.isEmpty()) {
            int[] cur = deque.poll();
            int x = cur[0];
            int time = cur[1];

            if(x == K) return time;

            // 순간이동 (0초 소요)
            if(x*2 <= 200000 && !visited[x*2]) {
                deque.addFirst(new int[]{x*2, time});
                visited[x*2] = true;
            }

            // 뒤로 이동
            if(x-1 >= 0 && !visited[x-1]) {
                deque.addLast(new int[]{x-1, time+1});
                visited[x-1] = true;
            }

            // 앞으로 이동
            if(x+1 <= 200000 && !visited[x + 1]) {
                deque.addLast(new int[]{x+1, time+1});
                visited[x+1] = true;
            }
        }

        return -1;
    }
}
