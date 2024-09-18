
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        StringBuilder answer = new StringBuilder();
        answer.append("<");

        Deque<Integer> deque = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            deque.offer(i);
        }

        while(deque.size() > 1) {
            for(int i=0; i<K-1; i++) {
                deque.offer(deque.poll());
            }
            answer.append(deque.poll()).append(", ");
        }

        answer.append(deque.poll()).append(">");
        System.out.println(answer);

        br.close();
    }
}