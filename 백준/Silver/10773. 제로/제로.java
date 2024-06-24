import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<K; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) stack.pop();
            else stack.push(input);
        }

        int answer = 0;
        while(!stack.empty())
            answer += stack.pop();

        System.out.println(answer);

        br.close();
    }
}