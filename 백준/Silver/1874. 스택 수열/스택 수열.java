import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int top = 1;
        boolean isError = false;

        StringBuilder sb = new StringBuilder(); // 한번에 출력하기 위한 변수

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            // 오름차순으로 push
            while(num >= top) {
                sb.append("+\n");
                stack.push(top);
                top++;
            }

            // 해당하는 숫자면 pop
            if(stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            }
            // 해당하는 숫자가 아니면 오름차순 push에 위배되므로 error
            else {
                isError = true;
                break;
            }
        }

        System.out.println(isError ? "NO" : sb);
        
        br.close();
    }
}