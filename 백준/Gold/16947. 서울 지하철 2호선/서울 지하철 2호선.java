import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static boolean[] cycle;
    static int[] result;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++) list.add(new ArrayList<>());

        // 양방향 그래프
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }

        // 순환선 찾기
        visited = new boolean[N+1];
        cycle = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            Arrays.fill(visited, false);
            if(find(i, 0, i, 0)) break;  // 하나의 순환선을 찾으면 종료
        }

        // 역에서 순환선까지 거리
        Arrays.fill(visited, false);
        result = new int[N+1];
        bfs();

        for(int i=1; i<=N; i++) System.out.print(result[i] + " ");

        br.close();
    }

    public static boolean find(int cur, int prev, int start, int count) {
        visited[cur] = true;

        for(int i: list.get(cur)) {
            if(i == prev) continue;

            if(visited[i]) {
                // 시작점으로 돌아왔고 길이가 2 이상인 경우 순환선
                if(i == start && count >= 2) {
                    cycle[cur] = true;
                    return true;
                }
                continue;  // 시작점이 아닌 방문한 노드면 건너뛰기
            }

            if(find(i, cur, start, count+1)) {
                cycle[cur] = true;
                return true;
            }
        }

        visited[cur] = false;
        return false;
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            if(!cycle[i]) continue;

            // 순환선인 경우 큐에 넣기
            queue.add(i);
            visited[i] = true;
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i: list.get(cur)) {
                if(visited[i]) continue;

                visited[i] = true;
                result[i] = result[cur]+1;
                queue.add(i);
            }
        }
    }
}
