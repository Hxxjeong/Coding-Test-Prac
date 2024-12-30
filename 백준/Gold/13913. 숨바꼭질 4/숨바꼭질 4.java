import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited = new boolean[100001];
    static int[] prev = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;
        prev[N] = -1;

        while(!queue.isEmpty()) {
            int pos = queue.poll();

            // 목표 위치에 도달한 경우
            if (pos == K) {
                printPath(K);
                return;
            }

            for(int i: new int[]{pos-1, pos+1, 2*pos}) {
                if(i >= 0 && i <= 100000 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    prev[i] = pos; // 이전 위치 기록
                }
            }
        }

        br.close();
    }

    private static void printPath(int end) {
        Stack<Integer> path = new Stack<>();
        for(int i=end; i!=-1; i=prev[i]) path.push(i);  // 역순으로 저장되므로 스택 필요

        System.out.println(path.size()-1);
        while (!path.isEmpty()) System.out.print(path.pop() + " ");
    }
}
