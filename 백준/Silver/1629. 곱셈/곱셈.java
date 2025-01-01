import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        long C = Long.parseLong(input[2]);

        System.out.println(calculate(A, B, C));

        br.close();
    }

    private static long calculate(long A, long B, long C) {
        if(B == 0) return 1;

        long half = calculate(A, B/2, C);   // 지수의 절반 (ex. a^10 => a^5)
        half = (half * half) % C;   // (A^(B/2))^2 % C (모듈러 연산)

        if(B % 2 == 1) half = (half * A) % C;   // 홀수인 경우 추가 곱셈 필요 (ex. a^9 => a^4 * a^4 * a)
        return half;
    }
}
