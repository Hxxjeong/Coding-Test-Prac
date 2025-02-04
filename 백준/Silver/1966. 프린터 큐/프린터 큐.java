import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            Queue<int[]> q = new LinkedList<>();    // 우선 순위, 인덱스 저장
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            input = br.readLine().split(" ");

            for(int i=0; i<N; i++) {
                int priority = Integer.parseInt(input[i]);
                q.add(new int[]{priority, i});
                pq.add(priority);
            }

            int count = 0;
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int priority = cur[0];
                int index = cur[1];

                // 우선 순위 큐의 제일 앞 요소와 비교
                if(priority == pq.peek()) {
                    pq.poll();
                    count++;  // 몇 번째로 인쇄되는지 카운트 증가

                    if(index == M) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
                else q.add(cur);  // 우선순위가 아니면 다시 큐에 삽입
            }
        }

        System.out.println(sb);

        br.close();
    }
}
