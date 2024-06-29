import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        while(!(input = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();

            if(input.equals(".")) break;

            input = input.replaceAll("[a-zA-Z.\\s]", "");   // 알파벳과 공백 제거
            if(input.equals("")) {  // 공백과 온점으로만 이루어진 경우
                System.out.println("yes");
                continue;
            }

            boolean right = true;
            for(char c: input.toCharArray()) {
                if(c == '(' || c == '[') stack.push(c);
                else {  // 닫힌 괄호일 때
                    if(stack.isEmpty()) {
                        right = false;
                        break;
                    }
                    else if(c == ')') {
                        if(stack.peek() == '(') stack.pop();
                        else {
                            right = false;
                            break;
                        }
                    }
                    else if(c == ']') {
                        if(stack.peek() == '[') stack.pop();
                        else {
                            right = false;
                            break;
                        }
                    }
                }
            }

            // 문자열 순회 후 스택이 비었는지 확인
            if(!stack.isEmpty()) right = false;

            System.out.println(right ? "yes" : "no");
        }
        br.close();
    }
}