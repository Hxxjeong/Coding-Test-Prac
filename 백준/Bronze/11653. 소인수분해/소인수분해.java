import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) return;

        boolean[] isPrime = new boolean[10_000_001];
        for(int i=2; i<isPrime.length; i++) isPrime[i] = true;

        for(int i=2; i*i<isPrime.length; i++) {
            if(isPrime[i]) {
                for(int j=i*i; j<isPrime.length; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        int i = 2;
        while(N != 1) {
            if(isPrime[i] && N % i == 0) {
                N /= i;
                System.out.println(i);
            }
            else i++;
        }

        br.close();
    }
}