import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static int[] distance;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        X = Integer.parseInt(input[3]);

        for(int i=0; i<=N; i++) list.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            list.get(A).add(B);
        }

        distance = new int[N+1];  // 거리와 방문 여부 모두 확인
        Arrays.fill(distance, -1);

        bfs(X);

        boolean find = false;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            if(distance[i] == K) {
                sb.append(i).append("\n");
                find = true;
            }
        }

        if(find) System.out.print(sb);
        else System.out.println("-1");

        br.close();
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i: list.get(cur)) {
                if(distance[i] != -1) continue;     // 이미 방문한 경우
                queue.add(i);
                distance[i] = distance[cur]+1;
            }
        }
    }
}