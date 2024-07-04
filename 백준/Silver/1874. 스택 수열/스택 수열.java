import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int pushNum = 1;    // 오름차순으로 push하기 위함
        boolean error = false;

        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            while(pushNum <= input) {
                stack.push(pushNum);  // 입력한 숫자까지 push
                sb.append("+").append("\n");

                pushNum++;
            }

            if(stack.peek() == input) {
                stack.pop();    // 수열 숫자에 해당하면 pop
                sb.append("-").append("\n");
            }
            else {  // pop 해야 하는 숫자와 input이 다른 경우
                error = true;
                break;
            }
        }

        System.out.println(error ? "NO" : sb);
    }
}