import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(0);
            return;
        }

        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=1; i<N; i++) pq.add(Integer.parseInt(br.readLine()));

        int answer = 0;
        while(!pq.isEmpty() && pq.peek() >= dasom) {
            int max = pq.poll();
            max--;
            dasom++;
            answer++;
            pq.add(max);
        }

        System.out.println(answer);

        br.close();
    }
}
