import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] type = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();    // 초기 상태
        int M = Integer.parseInt(br.readLine());
        int[] insert = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<N; i++) {
            if(type[i] == 0) queue.addFirst(input[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            queue.add(insert[i]);
            sb.append(queue.pollFirst()).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}