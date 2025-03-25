import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        // nCk = n!/k!(n-k)!
        if(K == 0 || K == N) System.out.println(1);
        else {
            BigInteger result = BigInteger.ONE;
            for(int i=1; i<=K; i++) {
                result = result.multiply(BigInteger.valueOf(N-K+i)).divide(BigInteger.valueOf(i));
            }
            
            System.out.println(result.mod(BigInteger.valueOf(10007)));
        }

        br.close();
    }
}