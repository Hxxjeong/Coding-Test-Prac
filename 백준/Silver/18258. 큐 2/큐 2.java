import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    queue.offer(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if(queue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;
                case "front":
                    if(queue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(queue.peek()).append("\n");
                    break;
                case "back":
                    if(queue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(queue.getLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);

        br.close();
    }
}