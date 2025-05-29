import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Map<Integer, Integer> kevin;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for(int i=0; i<=N; i++) list.add(new ArrayList<>());
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            list.get(A).add(B);
            list.get(B).add(A);
        }

        kevin = new HashMap<>();
        for(int i=1; i<=N; i++) {
            bfs(i);
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;
        for(int i=1; i<=N; i++) {
            if(kevin.get(i) < min) {
                min = kevin.get(i);
                answer = i;
            }
        }

        System.out.println(answer);

        br.close();
    }

    private static void bfs(int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        queue.add(new int[]{n, 0});
        visited[n] = true;

        int sum = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int depth = cur[1];

            sum += depth;

            for(int i: list.get(x)) {
                if(visited[i]) continue;

                visited[i] = true;
                queue.add(new int[]{i, depth+1});
            }
        }

        kevin.put(n, sum);
    }
}