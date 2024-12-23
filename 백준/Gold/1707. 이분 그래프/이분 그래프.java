import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] group;     // 각 정점의 그룹 (1 or 2)

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        for(int i=0; i<K; i++) {
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);     // 정점
            int E = Integer.parseInt(input[1]);     // 간선

            graph = new ArrayList<>();  // 그래프 초기화
            for(int j=0; j<=V; j++) graph.add(new ArrayList<>());

            // 양방향 그래프
            for(int j=0; j<E; j++) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            group = new int[V+1];
            boolean isPart = true;
            for(int j=1; j<=V; j++) {
                // 방문하지 않은 정점인 경우
                if(group[j] == 0) {
                    // 이분 그래프 판단
                    if(!bfs(j)) {
                        isPart = false;
                        break;
                    }
                }
            }

            sb.append(isPart ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        group[start] = 1;   // 첫번째 그룹으로 할당

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i: graph.get(cur)) {
                if(group[i] == 0) {
                    group[i] = 3 - group[cur];  // 연결되어 있으면 다른 그룹으로 할당
                    queue.add(i);
                }
                // 같은 그룹일 경우 이분 그래프가 아님
                else if(group[cur] == group[i]) return false;
            }
        }

        return true;
    }
}