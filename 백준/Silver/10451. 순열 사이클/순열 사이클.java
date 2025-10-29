import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            List<List<Integer>> list = new ArrayList<>();
            for(int i=0; i<=N; i++) list.add(new ArrayList<>());

            for(int i=0; i<N; i++) list.get(i+1).add(Integer.parseInt(input[i]));

            boolean[] visited = new boolean[N+1];
            int answer = 0;
            for(int i=1; i<=N; i++) {
                if(visited[i]) continue;

                bfs(list, visited, i);
                answer++;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static void bfs(List<List<Integer>> list, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i: list.get(cur)) {
                if(visited[i]) continue;

                queue.add(i);
                visited[i] = true;
            }
        }
    }
}