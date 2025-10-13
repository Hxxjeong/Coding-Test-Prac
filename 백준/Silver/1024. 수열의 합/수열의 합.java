import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long N = Long.parseLong(input[0]);
        int L = Integer.parseInt(input[1]);

        // x + (x+1) + (x+2) + ... + (x+L−1) = N (등차수열)
        // N = L * (2x + (L−1)) / 2
        // 2x = 2N/L - L + 1
        for(int i=L; i<=100; i++) {
            long X = 2 * N - (long) i * (i - 1);    // 분자 확인
            if(X < 0) break;

            if(X % (2 * i) == 0) {  // 분모 확인 (x가 정수인지 확인)
                long x = X / (2 * i);   // 시작값
                if (x >= 0) {
                    for(int j=0; j<i; j++) System.out.print((x + j) + " ");
                    return;
                }
            }
        }

        System.out.println(-1);

        br.close();
    }
}
