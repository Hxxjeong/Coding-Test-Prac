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
        while (N != 0) {
            int remainder = N % -2;     // 나머지
            N /= -2;

            // 나머지가 -1인 경우 1로 변경
            if (remainder < 0) {
                remainder += 2;
                N++;    // 2로 나누어 떨어지지 않았기 때문에 정수 나눗셈을 고려하여 나머지 추가
            }

            sb.append(remainder);
        }

        System.out.println(sb.reverse());

        br.close();
    }
}