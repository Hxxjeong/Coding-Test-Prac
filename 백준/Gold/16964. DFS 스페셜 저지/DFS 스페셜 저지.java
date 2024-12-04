import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] order;
    static int orderIndex = 0;

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
        order = new int[N];
        for(int i=0; i<N; i++) order[i] = Integer.parseInt(input[i]);

        visited = new boolean[N+1];

        // 주어진 배열이 dfs 탐색이 맞는지 확인
        if(order[0] == 1 && dfs(1)) System.out.println(1);
        else System.out.println(0);

        br.close();
    }

    public static boolean dfs(int index) {
        // 탐색 순서가 일치하지 않을 떄
        if(order[orderIndex++] != index) return false;

        visited[index] = true;

        // 인접 노드들을 order에서 나오는 순서에 따라 방문하도록 정렬
        list.get(index).sort(Comparator.comparingInt(o -> {
            for(int i=orderIndex; i<N; i++) {
                if(order[i] == o) return i;
            }
            return Integer.MAX_VALUE;
        }));

        for(int i: list.get(index)) {
            if(visited[i]) continue;

            if(!dfs(i)) return false;
        }

        return true;
    }
}
