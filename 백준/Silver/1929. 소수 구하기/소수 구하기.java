import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        boolean[] isPrime = new boolean[1_000_001];  // 해당 인덱스가 소수인지 확인하는 배열

        for(int i=2; i<isPrime.length; i++) isPrime[i] = true;  // 초기화

        // 에라토스테네스의 체 이용
        for(int i=2; i*i<isPrime.length; i++) {
            for(int j=i*i; j<isPrime.length; j+=i) {   // i를 제외한 i의 배수들은 소수가 아님
                isPrime[j] = false;
            }
        }

        // M 이상 N 이하의 소수 출력
        for(int i=M; i<=N; i++) {
            if(isPrime[i]) System.out.println(i);
        }

        br.close();
    }
}