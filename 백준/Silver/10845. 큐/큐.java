import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    queue.offer(Integer.valueOf(input[1]));
                    break;
                case "pop":
                    System.out.println(queue.isEmpty() ? "-1" : queue.poll());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? "1" : "0");
                    break;
                case "front":
                    System.out.println(queue.isEmpty() ? "-1" : queue.peek());
                    break;
                case "back":
                    System.out.println(queue.isEmpty() ? "-1" : queue.getLast());
                    break;
            }
        }

        br.close();
    }
}