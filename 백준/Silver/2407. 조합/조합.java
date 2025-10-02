import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // nCm = n! / m!(n-m)!
        BigInteger[][] comb = new BigInteger[101][101];
        for(int i=0; i<=n; i++) {
            comb[i][0] = comb[i][i] = BigInteger.valueOf(1);    // nC0 = nCn = 1
            for(int j=1; j<i; j++) {
                comb[i][j] = comb[i-1][j-1].add(comb[i-1][j]);
            }
        }

        System.out.println(comb[n][m]);
    }
}
