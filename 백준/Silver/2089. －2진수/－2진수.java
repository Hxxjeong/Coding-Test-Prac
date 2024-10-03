import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N이 0이면 그대로 0 출력
        if(N == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (N != 1) {
            // N이 양수인 경우
            if(N > 0) {
                sb.append(N % 2);   // 양수 2로 나눴을 때와 동일
                N /= -2;
            }
            // N이 음수인 경우
            else {
                // 절댓값이 2로 나누어 떨어질 때
                if(Math.abs(N) % 2 == 0) {
                    sb.append(0);
                    N /= -2;
                }
                // 절댓값이 2로 나누어 떨어지지 않을 때
                else {
                    sb.append(1);
                    N = Math.abs(N) / 2 + 1;    // 정수 몫이므로 나머지 추가
                }
            }
        }

        sb.append(1);   // 가장 마지막 자리 추가

        System.out.println(sb.reverse());

        br.close();
    }
}