import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if(n == 0) {
            System.out.println("0");
            return;
        }

        BigInteger[] fibo = new BigInteger[n+1];
        fibo[0] = BigInteger.ZERO;
        fibo[1] = BigInteger.ONE;
        for(int i=2; i<=n; i++) fibo[i] = fibo[i-1].add(fibo[i-2]);

        System.out.println(fibo[n]);

        br.close();
    }
}
