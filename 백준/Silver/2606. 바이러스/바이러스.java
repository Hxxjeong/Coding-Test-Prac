import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int connect = Integer.parseInt(br.readLine());

        for(int i=0; i<=computer; i++) list.add(new ArrayList<>());

        // 양방향 그래프
        for(int i=0; i<connect; i++) {
            String[] input = br.readLine().split(" ");
            list.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            list.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }

        visited = new boolean[computer+1];  // 0번 인덱스 사용 X
        System.out.println(bfs(1));

        br.close();
    }

    public static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int answer = 0;
        while(!queue.isEmpty()) {
            int com = queue.poll();

            for(int i: list.get(com)) {
                if(visited[i]) continue;

                queue.add(i);
                visited[i] = true;
                answer++;
            }
        }

        return answer;
    }
}