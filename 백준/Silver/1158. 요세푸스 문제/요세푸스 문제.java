import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(queue.size() != 1) {
            for(int i=0; i<K-1; i++) {
                queue.offer(queue.poll());  // k번째 전까지 큐에서 뽑아서 맨 뒤로 보내기
            }
            sb.append(queue.poll()).append(", ");   // k번째 수를 뽑아서 sb에 추가
        }

        sb.append(queue.poll());    // 큐에 있는 마지막 원소 뽑기
        sb.append(">");

        System.out.println(sb);
        br.close();
    }
}
