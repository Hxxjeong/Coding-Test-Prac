import java.io.*;
import java.util.*;

public class Main {
    static boolean find = false;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i=0; i<N; i++) list.add(new ArrayList<>());

        // 양방향 그래프
        for(int i=0; i<M; i++) {
            String[] person = br.readLine().split(" ");
            list.get(Integer.parseInt(person[0])).add(Integer.parseInt(person[1]));
            list.get(Integer.parseInt(person[1])).add(Integer.parseInt(person[0]));
        }

        visited = new boolean[N];
        for(int i=0; i<N; i++) {
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;

            if(find) break;     // A~E의 친구 관계가 성립할 때
        }

        System.out.println(find ? 1 : 0);

        br.close();
    }

    public static void dfs(int start, int depth) {
        if(depth == 4) {
            find = true;
            return;
        }

        for(int i: list.get(start)) {
            if(visited[i]) continue;

            visited[i] = true;
            dfs(i, depth+1);
            visited[i] = false;
        }
    }
}