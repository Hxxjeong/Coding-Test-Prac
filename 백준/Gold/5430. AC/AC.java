import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // test case 개수

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            String[] func = br.readLine().split("");    // 수행할 함수
            int n = Integer.parseInt(br.readLine());    // 배열의 수
            String arr = br.readLine(); // 배열
            arr = arr.substring(1, arr.length()-1); // 괄호 제거

            String[] element = arr.isEmpty() ? new String[0] : arr.split(",");

            // 큐에 원소 추가
            LinkedList<Integer> deque = new LinkedList<>();
            for(String e: element) {
                if(!e.isEmpty()) deque.offer(Integer.parseInt(e));   // 원소가 있을 때만 추가
            }

            boolean isError = false;    // 에러 연산 확인
            boolean reversed = false;   // reversed가 true일 때만 뒤집기

            // 함수 계산
            for(String f: func) {
                if(f.equals("R")) {
                    reversed = !reversed;
                }
                else if(f.equals("D")) {
                    if(deque.isEmpty()) {
                        sb.append("error").append("\n");
                        isError = true;
                        break;
                    }

                    if(reversed) deque.pollLast();  // 뒤집어야 하는 경우 마지막 원소 제거
                    else deque.pollFirst();
                }
            }

            if(isError) continue;   // error 출력인 경우 배열 출력 skip

            // 배열 출력
            sb.append("[");
            while(!deque.isEmpty()) {
                if(reversed) sb.append(deque.pollLast());   // 뒤집어야 하는 경우 마지막부터 출력
                else sb.append(deque.pollFirst());

                if(!deque.isEmpty()) sb.append(",");
            }
            sb.append("]\n");
        }

        System.out.print(sb);

        br.close();
    }
}