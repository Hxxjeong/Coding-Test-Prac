import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
            }
            else {
                stack.pop();

                // 레이저인 경우
                if (input.charAt(i-1) == '(') {
                    answer += stack.size(); // (의 개수만큼 더함
                }
                else {  // 막대기의 끝인 경우
                    answer++;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}