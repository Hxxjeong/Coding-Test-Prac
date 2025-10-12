import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i*i<=10000; i++) {
            if(isPrime[i]) {
                for(int j=i*i; j<=10000; j+=i) isPrime[j] = false;
            }
        }

        int sum = 0;
        int num = 0;
        for(int i=M; i<=N; i++) {
            if(isPrime[i]) sum += i;
        }

        if(sum > 0) {
            for(int i=M; i<=N; i++) {
                if(isPrime[i]) {
                    num = i;
                    break;
                }
            }
        }
        else {
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
        System.out.println(num);

        br.close();
    }
}
