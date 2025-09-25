import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<input.length; j++) queue.add(Integer.parseInt(input[j]));
        }

        int i = 1;
        while(i < N) {
            queue.poll();
            i++;
        }
        System.out.println(queue.poll());

        br.close();
    }
}