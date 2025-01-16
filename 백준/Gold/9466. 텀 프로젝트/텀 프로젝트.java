import java.io.*;

public class Main {
    static int count;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished; // DFS 탐색 종료 여부

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            arr = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];

            for(int j=1; j<=n; j++) arr[j] = Integer.parseInt(input[j-1]);

            count = 0;
            for(int j=1; j<=n; j++) if(!visited[j]) dfs(j);

            sb.append(n - count).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        int next = arr[start];

        if(!visited[next]) dfs(next);
        // 사이클인 경우
        else if(!finished[next]) {
            count++;
            for(int i=next; i!=start; i=arr[i]) count++;
        }

        finished[start] = true; // 현재 학생의 탐색 종료
    }
}
