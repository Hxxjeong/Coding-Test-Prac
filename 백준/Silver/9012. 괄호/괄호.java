import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;

            for(char c: input.toCharArray()) {
                if(c == '(') stack.push(c);
                else {
                    if(stack.isEmpty()) {
                        isVPS = false;
                        break;
                    }
                    else stack.pop();
                }
            }

            if(!stack.isEmpty()) isVPS = false;

            System.out.println(isVPS ? "YES" : "NO");
        }

        br.close();
    }
}