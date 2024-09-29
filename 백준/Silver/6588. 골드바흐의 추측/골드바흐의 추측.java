import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] isPrime = new boolean[1_000_001];  // 해당 인덱스가 소수인지 확인하는 배열

        for(int i=2; i<isPrime.length; i++) isPrime[i] = true;  // 초기화

        // 에라토스테네스의 체 이용
        for(int i=2; i*i<isPrime.length; i++) {
            if(isPrime[i]) {
                for (int j=i*i; j<isPrime.length; j+=i) {   // i를 제외한 i의 배수들은 소수가 아님
                    isPrime[j] = false;
                }
            }
        }

        String input;
        while(!(input = br.readLine()).equals("0")) {
            int number = Integer.parseInt(input);
            boolean find = false;

            for(int i=3; i<=number/2; i+=2) {   // 홀수인 소수 확인
                if(isPrime[i] && isPrime[number-i]) {
                    bw.write(number + " = " + i + " + " + (number-i) + "\n");
                    find = true;
                    break;
                }
            }

            // 찾지 못한 경우
            if (!find) bw.write("Goldbach's conjecture is wrong.");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}