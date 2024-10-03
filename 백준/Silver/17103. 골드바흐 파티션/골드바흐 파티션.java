import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[1_000_001];

        for(int i=2; i<isPrime.length; i++) isPrime[i] = true;  // 초기화

        // 소수 판별
        for(int i=2; i*i<isPrime.length; i++) {
            if(isPrime[i]) {
                for (int j=i*i; j<isPrime.length; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;

            for(int j=2; j<=N/2; j++) {
                if(isPrime[j] && isPrime[N-j]) {
                    answer++;
                }
            }

            System.out.println(answer);
        }

        br.close();
    }
}