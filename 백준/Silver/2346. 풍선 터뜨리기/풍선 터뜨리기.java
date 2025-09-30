import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) deque.add(new int[]{i+1, Integer.parseInt(input[i])}); // 풍선 번호, 값

        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            int[] cur = deque.poll();   // 이미 오른쪽으로 한 칸 이동한 상태
            sb.append(cur[0]).append(" ");
            int move = cur[1];

            if(deque.isEmpty()) break;  // 마지막 풍선인 경우

            if(move > 0) {
                for(int i=1; i<move; i++) deque.addLast(deque.pollFirst());
            }
            else {
                for(int i=0; i<Math.abs(move); i++) deque.addFirst(deque.pollLast());
            }
        }

        System.out.println(sb);

        br.close();
    }
}