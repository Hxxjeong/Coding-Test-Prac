import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);     // 정점
        int M = Integer.parseInt(input[1]);     // 간선
        int V = Integer.parseInt(input[2]);     // 시작 정점

        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        // 양방향 그래프
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 정점 리스트 정렬
        for (List<Integer> list: graph) Collections.sort(list);

        visited = new boolean[N+1];
        List<Integer> result = new ArrayList<>();
        dfs(result, V);
        for(int i: result) System.out.print(i + " ");
        System.out.println();

        result.clear();
        Arrays.fill(visited, false);
        bfs(result, V);
        for(int i: result) System.out.print(i + " ");

        br.close();
    }

    public static void dfs(List<Integer> result, int index) {
        visited[index] = true;
        result.add(index);

        for(int i: graph.get(index)) {
            if(!visited[i]) dfs(result, i);
        }
    }

    public static void bfs(List<Integer> result, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);
            visited[cur] = true;

            for(int i: graph.get(cur)) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}