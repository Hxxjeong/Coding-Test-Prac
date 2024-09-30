import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger[] zeroCount = new BigInteger[501];
        zeroCount[0] = BigInteger.valueOf(1);
        zeroCount[1] = BigInteger.valueOf(1);

        for(int i=2; i<=N; i++) {
            zeroCount[i] = (zeroCount[i-1].multiply(BigInteger.valueOf(i)));
        }

        int i = String.valueOf(zeroCount[N]).length() - 1;
        long answer = 0;
        // 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수
        while(String.valueOf(zeroCount[N]).charAt(i) == '0') {
            answer++;
            i--;
        }

        System.out.println(answer);

        br.close();
    }
}