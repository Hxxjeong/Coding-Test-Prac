import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Stack<Integer> stack = new Stack<>();   // 원래 줄
        for(int i=N-1; i>=0; i--) stack.push(Integer.parseInt(input[i]));

        Stack<Integer> line = new Stack<>();    // 대기 열

        int turn = 1;
        while(!stack.isEmpty() || !line.isEmpty()){
            boolean moved = false;

            // 원래 줄에서 바로 입장
            if(!stack.isEmpty() && stack.peek() == turn) {
                stack.pop();
                turn++;
                moved = true;
            }
            // 대기열에서 바로 입장
            else if(!line.isEmpty() && line.peek() == turn) {
                line.pop();
                turn++;
                moved = true;
            }
            // 대기열로 이동
            else if(!stack.isEmpty()) {
                line.push(stack.pop());
                moved = true;
            }

            // 원래 줄, 대기열에서 모두 움직일 수 없으면 실패
            if(!moved) {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");

        br.close();
    }
}