import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        int[] numbers = new int[1_000_001]; // 숫자가 나온 횟수 (0번 인덱스 사용 X)
        int[] answer = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]); // String to int
            numbers[arr[i]]++;  // 각 숫자의 등장 횟수 저장
        }

        Stack<Integer> stack = new Stack<>();

        // 배열 역순으로 순회
        for(int i=N-1; i>=0; i--) {
            // 현재 스택에 있는 횟수가 더 적게 나온 숫자면 스택에서 제거
            while(!stack.isEmpty() && numbers[stack.peek()] <= numbers[arr[i]]) {
                stack.pop();
            }

            if(stack.isEmpty()) answer[i] = -1; // 스택에 비어 있는 경우 오등큰수가 존재하지 않음
            else answer[i] = stack.peek();  // 그렇지 않은 경우 스택의 가장 윗부분이 오등큰수

            stack.push(arr[i]);    // 현재 숫자를 스택에 추가
        }

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i: answer) bw.write(i + " ");

        bw.close();
        br.close();
    }
}