import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // 연산자 우선순위 (숫자가 높을수록 더 높은 우선순위)
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('(', 0);    // 여는 괄호 스택에 우선 추가

        for(char c: input.toCharArray()) {
            // 알파벳인 경우 결과 문자열에 추가
            if(c >= 'A' && c <= 'Z')
                sb.append(c);
            // 여는 괄호인 경우 (괄호 조건 먼저 처리)
            else if (c == '(') {
                stack.push(c);
            }
            // 닫는 괄호인 경우
            else if (c == ')') {
                // 여는 괄호를 만날 때까지 스택에서 연산자를 꺼내서 결과에 추가
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // 여는 괄호 제거
            }
            // 연산자인 경우
            else if(map.containsKey(c)) {
                // 현재 연산자의 우선순위보다 낮거나 같은 우선순위의 연산자는 스택에서 모두 제거 후 결과 문자열에 추가
                while(!stack.isEmpty() && map.get(stack.peek()) >= map.get(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);  // 현재 연산자 스택에 추가
            }
        }

        // 스택에 남아있는 연산자 결과 문자열에 추가
        while(!stack.isEmpty()) sb.append(stack.pop());

        System.out.println(sb);

        br.close();
    }
}