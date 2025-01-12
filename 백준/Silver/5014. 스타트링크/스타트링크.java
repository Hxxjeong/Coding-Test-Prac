import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        F = Integer.parseInt(input[0]);     // 최고층
        S = Integer.parseInt(input[1]);     // 현재 위치
        G = Integer.parseInt(input[2]);     // 목표
        U = Integer.parseInt(input[3]);
        D = Integer.parseInt(input[4]);

        visited = new boolean[F+1];

        int result = bfs();
        System.out.println(result == -1 ? "use the stairs" : result);

        br.close();
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, 0});
        visited[S] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int answer = cur[1];

            if(pos == G) return answer;

            for(int i: new int[]{pos+U, pos-D}) {
                if(i <= 0 || i > F || visited[i]) continue;

                queue.add(new int[]{i, answer+1});
                visited[i] = true;
            }
        }

        return -1;
    }
}
