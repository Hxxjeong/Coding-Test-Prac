import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);     // 최소 공 개수 K(K+1)/2
        int K = Integer.parseInt(input[1]);

        int S = K * (K+1) / 2;
        if(N < S) {
            System.out.println(-1);
            return;
        }

        int r = N - S;
        int extra = (r % K == 0) ? 0 : 1;
        System.out.println((K-1) + extra);

        br.close();
    }
}
