import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        input = br.readLine().split(" ");
        for(int j=0; j<N; j++) pq.add(Integer.parseInt(input[j]));
        input = br.readLine().split(" ");
        for(int j=0; j<M; j++) pq.add(Integer.parseInt(input[j]));

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) sb.append(pq.poll()).append(" ");
        System.out.println(sb);

        br.close();
    }
}