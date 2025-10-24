import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] answer;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
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

        for(int i=1; i<=N; i++) Collections.sort(list.get(i));

        answer = new int[N+1];
        bfs(R);

        for(int i=1; i<=N; i++) System.out.println(answer[i]);

        br.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[N+1];
        visited[start] = true;

        int count = 1;
        answer[start] = count;
        while(!queue.isEmpty()) {
            int u = queue.poll();

            for(int i: list.get(u)) {
                if(visited[i]) continue;

                queue.add(i);
                visited[i] = true;
                answer[i] = ++count;
            }
        }
    }
}