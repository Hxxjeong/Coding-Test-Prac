import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) sb.append(queue.isEmpty() ? "0" : queue.poll()).append("\n");
            else queue.add(input);
        }

        System.out.println(sb);

        br.close();
    }
}
