import java.io.*;
import java.util.*;

public class Main {
    static int[] answer;
    static boolean[] visited;
    static List<List<Integer>> list;
    static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        list = new ArrayList<>();
        for(int i=0; i<=N; i++) list.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=1; i<=N; i++) Collections.sort(list.get(i));

        answer = new int[N+1];
        visited = new boolean[N+1];
        dfs(R);

        for(int i=1; i<=N; i++) System.out.println(answer[i]);

        br.close();
    }

    private static void dfs(int node) {
        visited[node] = true;
        answer[node] = order++;

        for(int i: list.get(node)) {
            if(!visited[i]) dfs(i);
        }
    }
}