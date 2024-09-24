import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 빌딩 개수

        Stack<Integer> stack = new Stack<>();
        long answer = 0;
        int[] buildings = new int[N];

        for(int i=0; i<N; i++) {
            buildings[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N; i++) {
            // 스택에 계속 추가하다가 높은 빌딩이 나오면 시야가 가려짐
            // 자신보다 낮은 빌딩이 나오면 스택에서 제거
            while (!stack.isEmpty() && stack.peek() <= buildings[i]) {
                stack.pop();
            }

            // 스택에 남아있는 모든 빌딩의 개수를 더함
            answer += stack.size();

            // 현재 빌딩을 스택에 추가
            stack.push(buildings[i]);
        }

        System.out.println(answer);
        br.close();
    }
}