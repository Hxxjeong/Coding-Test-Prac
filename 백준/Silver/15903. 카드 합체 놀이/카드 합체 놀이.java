import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");

        Queue<Long> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++) queue.add(Long.parseLong(input[i]));

        for(int i=0; i<m; i++) {
            long x = queue.poll();
            long y = queue.poll();

            queue.add(x+y);
            queue.add(x+y);
        }

        long answer = 0;
        while(!queue.isEmpty()) answer += queue.poll();

        System.out.println(answer);

        br.close();
    }
}