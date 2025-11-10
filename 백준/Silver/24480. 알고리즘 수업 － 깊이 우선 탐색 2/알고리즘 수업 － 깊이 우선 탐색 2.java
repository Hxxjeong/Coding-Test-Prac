import java.io.*;
import java.util.*;

public class Main {
    static int order = 1;
    static int[] answer;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        for(int i=0; i<=N; i++) list.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for(int i=1; i<=N; i++) Collections.sort(list.get(i), Collections.reverseOrder());

        answer = new int[N+1];
        visited = new boolean[N+1];
        dfs(R, 0);

        for(int i=1; i<=N; i++) System.out.println(answer[i]);

        br.close();
    }

    private static void dfs(int r, int depth) {
        visited[r] = true;
        answer[r] = order++;

        for(int i: list.get(r)) {
            if(visited[i]) continue;
            dfs(i, depth+1);
        }
    }
}