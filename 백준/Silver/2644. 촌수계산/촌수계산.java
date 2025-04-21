import java.io.*;
import java.util.*;

public class Main {
    static int n, m, start, end;
    static int answer = 0;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);

        m = Integer.parseInt(br.readLine());

        for(int i=0; i<=n; i++) list.add(new ArrayList<>());
        for(int i=0; i<m; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            list.get(x).add(y);
            list.get(y).add(x);
        }

        visited = new boolean[n+1];
        answer = bfs(start, end);
        System.out.println(answer);

        br.close();
    }

    private static int bfs(int s, int e) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s, 1});
        visited[s] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int ans = cur[1];

            for(int i: list.get(x)) {
                if(visited[i]) continue;

                if(i == e) return ans;

                visited[i] = true;
                queue.add(new int[]{i, ans+1});
            }
        }

        return -1;
    }
}