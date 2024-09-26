import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Object> stack = new Stack<>();
        int answer = 0;
        int temp = 1;   // 중간 값을 저장하는 변수

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            if(c == '(') {
                stack.push(c);
                temp *= 2;
            }
            else if(c == '[') {
                stack.push(c);
                temp *= 3;
            }
            else if(c == ')') {
                // 올바르지 않은 문자열일 경우
                if(stack.isEmpty() || !stack.peek().equals('(')) {
                    System.out.println(0);
                    return;
                }

                if(input.charAt(i-1) == '(') {
                    answer += temp;  // "()"인 경우 그동안 곱한 중간 값을 더해줌
                }
                stack.pop(); // '(' 제거
                temp /= 2;   // 중간 값 원래대로 복구
            }
            else {
                // 올바르지 않은 문자열인 경우
                if(stack.isEmpty() || !stack.peek().equals('[')) {
                    System.out.println(0);
                    return;
                }

                if(input.charAt(i-1) == '[') {
                    answer += temp;  // "[]"인 경우 그동안 곱한 중간 값을 더해줌
                }
                stack.pop(); // '[' 제거
                temp /= 3;   // 중간 값 원래대로 복구
            }
        }

        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(answer);

        br.close();
    }
}