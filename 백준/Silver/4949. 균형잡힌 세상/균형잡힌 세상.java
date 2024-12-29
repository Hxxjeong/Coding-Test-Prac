import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        StringBuilder sb = new StringBuilder();
        a: while(!(input = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();

            input = input.replaceAll("[a-zA-Z' '.]", "");

            for(char c: input.toCharArray()) {
                if(c == '(' || c == '[') stack.push(c);
                else if(c == ')' || c == ']') {
                    if (stack.isEmpty() || (c == ')' && stack.peek() != '(') || (c == ']' && stack.peek() != '[')) {
                        sb.append("no").append("\n");
                        continue a;
                    }

                    stack.pop();
                }
            }

            if(stack.isEmpty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
