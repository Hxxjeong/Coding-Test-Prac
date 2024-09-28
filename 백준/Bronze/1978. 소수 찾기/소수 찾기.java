import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[1001];  // 해당 인덱스가 소수인지 확인

        for(int i=2; i<isPrime.length; i++) isPrime[i] = true;  // 초기화

        // 에라토스테네스의 체 이용
        for(int i=2; i*i<=isPrime.length; i++) {
            for(int j=i*i; j< isPrime.length; j+=i) {   // i를 제외한 배수들은 소수가 아님
                isPrime[j] = false;
            }
        }

        String[] input = br.readLine().split(" ");
        int answer = 0;
        for(int i=0; i<N; i++) {
            if(isPrime[Integer.parseInt(input[i])]) answer++;
        }

        System.out.println(answer);

        br.close();
    }
}