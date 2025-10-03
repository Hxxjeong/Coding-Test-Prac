import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[2_000_001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2; i*i<isPrime.length; i++) {
            if(isPrime[i]) for(int j=i*i; j<isPrime.length; j+=i) isPrime[j] = false;
        }

        for(int i=N; i<isPrime.length; i++) {
            if(isPrime[i]) {
                StringBuilder sb = new StringBuilder(String.valueOf(i));
                if(sb.toString().contentEquals(sb.reverse())) {
                    System.out.println(i);
                    return;
                }
            }
        }

        br.close();
    }
}
