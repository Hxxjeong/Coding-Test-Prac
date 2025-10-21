import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++) list.add(new ArrayList<>());

        for(int i=0; i<m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int answer = bfs(list);
        System.out.println(answer);

        br.close();
    }

    public static int bfs(List<List<Integer>> list) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        boolean[] visited = new boolean[list.size()];
        visited[1] = true;

        int count = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int depth = cur[1];

            if(depth == 2) continue;    // 친구의 친구까지만 허용

            for(int i: list.get(node)) {
                if(visited[i]) continue;

                queue.add(new int[]{i, depth+1});
                visited[i] = true;
                count++;
            }
        }

        return count;
    }
}