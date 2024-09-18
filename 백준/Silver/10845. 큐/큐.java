import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");

            switch(input[0]) {
                case "push":
                    deque.offer(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
                    break;
                case "back":
                    System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
                    break;
            }
        }

        br.close();
    }
}