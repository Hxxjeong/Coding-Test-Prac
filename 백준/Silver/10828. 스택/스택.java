import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 명령 개수

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");

            switch(input[0]) {
                case "push":
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    System.out.println(pop(stack));
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(isEmpty(stack));
                    break;
                case "top":
                    System.out.println(top(stack));
                    break;
            }
        }

        br.close();
    }

    static int pop(Stack<Integer> stack) {
        return stack.isEmpty() ? -1 : stack.pop();
    }

    static int isEmpty(Stack<Integer> stack) {
        return stack.isEmpty() ? 1 : 0;
    }

    static int top(Stack<Integer> stack) {
        return stack.isEmpty() ? -1 : stack.peek();
    }
}