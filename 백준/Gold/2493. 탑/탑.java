import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(input[i]);

        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++) {
            // 현재 요소가 더 크면 스택에서 제거
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();

            if(stack.isEmpty()) answer[i] = 0;  // 탐지할 수 있는 탑이 없으면 0
            else answer[i] = stack.peek() + 1;  // 시작점이 1

            stack.push(i);
        }

        Arrays.stream(answer).forEach(s -> System.out.print(s + " "));

        br.close();
    }
}