import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(input[i]); // String to int

        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();

        // 배열 역순으로 순회
        for(int i=N-1; i>=0; i--) {
            // 현재 숫자보다 작거나 같은 수는 스택에서 제거
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) answer[i] = -1;     // 스택이 비어 있는 경우 오큰수가 존재하지 않음
            else answer[i] = stack.peek();  // 그렇지 않은 경우 스택의 가장 위의 값이 오큰수

            stack.push(arr[i]);  // 현재 숫자를 스택에 추가
        }

        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i: answer) bw.write(i + " ");

        bw.close();
        br.close();
    }
}