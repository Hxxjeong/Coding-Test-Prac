import java.io.*;

public class Main {
    static final long MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] fibo = new long[2_000_001];
        fibo[1_000_000] = 0;
        fibo[1_000_001] = 1;
        for(int i=1_000_002; i<=2_000_000; i++) fibo[i] = (fibo[i-1] + fibo[i-2]) % MOD;
        for(int i=999_999; i>=0; i--) fibo[i] = (fibo[i+1] + fibo[i+2]) % MOD;

        long value = fibo[N+1_000_000];

        // 부호 (F(−n) = (−1)^(n+1) * F(n))
        int sign;
        if(value == 0) sign = 0;
        else {
            if (N >= 0) sign = 1;
            else {  // N < 0인 경우 부호 적용
                if((-N) % 2 == 0) sign = -1; // 짝수면 음수
                else sign = 1; // 홀수면 양수
            }
        }

        System.out.println(sign);
        System.out.println(value);

        br.close();
    }
}
