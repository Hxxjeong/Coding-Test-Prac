import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 피연산자 개수
        String input = br.readLine();   // 후위 표기식
        int[] numbers = new int[N];

        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int i=0; i<input.length(); i++) {
            char index = input.charAt(i);

            // 숫자인 경우 스택에 추가
            if(index >= 'A' && index <= 'Z') {
                stack.push((double) numbers[index-'A']);
            }
            // 연산자인 경우
            else {
                double num1 = stack.pop();
                double num2 = stack.pop();
                double middleAnswer = 0;

                switch(index) {
                    case '+':
                        middleAnswer = num1 + num2;
                        break;
                    case '-':
                        middleAnswer = num2 - num1;
                        break;
                    case '*':
                        middleAnswer = num1 * num2;
                        break;
                    case '/':
                        middleAnswer = num2 / num1;
                        break;
                }

                stack.push(middleAnswer);   // 중간 연산 값을 스택에 추가
            }
        }

        // 소수점 둘째 자리까지 출력
        System.out.printf("%.2f", stack.pop());

        br.close();
    }
}