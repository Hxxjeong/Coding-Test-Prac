import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        a: for(int i=0; i<T; i++) {
            char[] input = br.readLine().toCharArray();

            boolean isVPS = true;
            Stack<Character> stack = new Stack<>();

            for (char c: input) {
                if (c == '(') stack.push(c);
                else {
                    // 닫힌 괄호일 때 스택이 비어 있으면 VPS가 아니므로 다음 문자열 검사
                    if(stack.isEmpty()) {
                        System.out.println("NO");
                        continue a;
                    }
                    else stack.pop();
                }
            }

            isVPS = stack.isEmpty();
            System.out.println(isVPS ? "YES" : "NO");
        }

        br.close();
    }
}