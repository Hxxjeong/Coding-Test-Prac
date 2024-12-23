import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        a: for(int i=0; i<N; i++) {
            String input = br.readLine();

            Stack<Character> stack = new Stack<>();
            int[] arr = new int[26];
            for(char c: input.toCharArray()) {
                if(stack.isEmpty() || stack.peek() == c || arr[c-'a'] == 0) {
                    stack.push(c);
                    arr[c-'a']++;
                }
                else if(stack.peek() != c && arr[c-'a'] > 0) continue a;     // 떨어져서 나타난 경우
            }

            count++;
        }

        System.out.println(count);

        br.close();
    }
}
