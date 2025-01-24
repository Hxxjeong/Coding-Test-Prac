import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] answer;
    static boolean[] visited;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        list = new ArrayList<>();
        for(int i=0; i<=N; i++) list.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            list.get(B).add(A);
        }

        answer = new int[N+1];
        Arrays.fill(answer, -1);
        for(int i=1; i<=N; i++) if(answer[i] == -1) bfs(i);

        int max = Arrays.stream(answer).max().getAsInt();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) if(answer[i] == max) sb.append(i).append(" ");

        System.out.println(sb);

        br.close();
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N+1];
        queue.add(start);
        visited[start] = true;

        int count = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i: list.get(cur)) {
                if(visited[i]) continue;

                visited[i] = true;
                queue.add(i);
                count++;
            }
        }

        answer[start] = count;
    }
}