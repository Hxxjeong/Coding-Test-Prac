import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] answer;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) list.add(new ArrayList<>());
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<input.length; j++) {
                if(input[j].equals("1")) list.get(i).add(j);
            }
        }

        answer = new int[N][N];
        for(int i=0; i<N; i++) {
            visited = new boolean[N];
            dfs(i, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) sb.append(answer[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static void dfs(int start, int cur) {
        for(int i: list.get(cur)) {
            if(visited[i]) continue;

            visited[i] = true;
            answer[start][i] = 1;
            dfs(start, i);
        }
    }
}