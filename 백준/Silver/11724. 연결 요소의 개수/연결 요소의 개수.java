import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        // 양방향 그래프
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N+1];
        int answer = 0;
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }

    public static void dfs(int index) {
        visited[index] = true;

        for(int i: graph.get(index)) {
            if(!visited[i])
                dfs(i);
        }
    }
}