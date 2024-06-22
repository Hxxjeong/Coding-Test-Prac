import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            char[] input = br.readLine().toCharArray();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (char c : input) {
                if (c == '<') { // 왼쪽으로 커서 이동
                    if (!left.empty()) right.push(left.pop()); // 오른쪽 스택에 임시 저장
                }
                else if (c == '>') { // 오른쪽으로 커서 이동
                    if (!right.empty()) left.push(right.pop()); // 왼쪽 스택에 넣기
                }
                else if (c == '-') {
                    if (!left.empty()) left.pop(); // 왼쪽 스택의 문자 지우기
                }
                else
                    left.push(c);
            }

            // 문자 순서 고려
            while (!left.empty())
                right.push(left.pop());

            while (!right.empty())
                bw.write(right.pop());

            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}