import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++) list.add(new ArrayList<>());

        // 양방향 그래프
        for(int i=0; i<N-1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }

        String[] input = br.readLine().split(" ");
        int[] order = new int[N];
        int[] position = new int[N+1];  // 각 노드의 위치 저장
        for(int i=0; i<N; i++) {
            order[i] = Integer.parseInt(input[i]);
            position[order[i]] = i;
        }

        visited = new boolean[N+1];

        // 주어진 배열이 bfs 탐색이 맞는지 확인
        if(bfs(order, position)) System.out.println(1);
        else System.out.println(0);

        br.close();
    }

    public static boolean bfs(int[] order, int[] position) {
        if(order[0] != 1) return false;  // 시작 정점 1

        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(1);

        int index = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            List<Integer> neighbor = new ArrayList<>();     // 인접하는 정점
            for(int i: list.get(cur)) {
                if (visited[i]) continue;

                visited[i] = true;
                neighbor.add(i);
            }

            // order의 순서로 정렬
            neighbor.sort(Comparator.comparingInt(a -> position[a]));

            // 다음 레벨의 노드 순서를 비교
            for(int i=0; i<neighbor.size(); i++) {
                if(index >= N || neighbor.get(i) != order[index]) return false;
                queue.add(order[index]);
                index++;
            }
        }

        return index == N;  // 모든 정점을 방문했는지 확인
    }
}
