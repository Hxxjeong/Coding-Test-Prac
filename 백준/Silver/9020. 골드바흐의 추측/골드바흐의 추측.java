import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[10001];
        for(int i=2; i<=10000; i++) isPrime[i] = true;

        for(int i=2; i*i<=10000; i++) {
            for(int j=i*i; j<=10000; j+=i) isPrime[j] = false;
        }

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());

            int start = n/2;
            while(start >= 2) {
                if(isPrime[start] && isPrime[n-start]) {
                    sb.append(start).append(" ").append(n-start).append("\n");
                    break;
                }

                start--;
            }
        }

        System.out.println(sb);

        br.close();
    }
}
