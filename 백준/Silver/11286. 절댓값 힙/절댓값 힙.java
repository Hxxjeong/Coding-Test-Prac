import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(Math.abs(a) == Math.abs(b)) return a - b;
            return Math.abs(a) - Math.abs(b);
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0) pq.add(x);
            else {
                if (pq.isEmpty()) sb.append("0").append("\n");
                else sb.append(pq.poll()).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}
