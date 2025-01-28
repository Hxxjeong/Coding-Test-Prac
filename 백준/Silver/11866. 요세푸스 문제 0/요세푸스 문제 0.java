import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) queue.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(queue.size() != 1) {
            for(int i=1; i<K; i++) queue.add(queue.poll());
            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append(">");
        System.out.println(sb);

        br.close();
    }
}
