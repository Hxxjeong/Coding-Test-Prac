import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i=0; i<N; i++) {
            String input = br.readLine();

            boolean goodWord = true;
            Stack<Character> stack = new Stack<>();

            for(char c: input.toCharArray()) {
                if(stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                char word = stack.peek();
                if(word == c) stack.pop();  // 값이 서로 다르면 push
                else stack.push(c);
            }

            // 스택이 비어있어야 좋은 단어
            if(!stack.isEmpty()) goodWord = false;

            count = goodWord ? ++count : count;
        }

        System.out.println(count);

        br.close();
    }
}