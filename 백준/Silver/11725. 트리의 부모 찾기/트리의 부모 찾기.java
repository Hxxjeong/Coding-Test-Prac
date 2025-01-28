import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for(int i=0; i<=N; i++) list.add(new ArrayList<>());

        for(int i=1; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }

        arr = new int[N+1];
        visited = new boolean[N+1];
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++) sb.append(arr[i]).append("\n");

        System.out.println(sb);

        br.close();
    }

    public static void dfs(int start) {
        visited[start] = true;

        for(int i: list.get(start)) {
            if(!visited[i]) {
                arr[i] = start;
                dfs(i);
            }
        }
    }
}
