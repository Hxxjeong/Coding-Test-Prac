import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            String input = br.readLine();

            if(input.startsWith("1")) stack.push(Integer.parseInt(input.split(" ")[1]));
            else if(input.startsWith("2")) sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
            else if(input.startsWith("3")) sb.append(stack.size()).append("\n");
            else if(input.startsWith("4")) sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            else if(input.startsWith("5")) sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}