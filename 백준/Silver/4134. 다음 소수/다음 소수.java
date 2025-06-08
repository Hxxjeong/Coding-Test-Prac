import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            long n = Long.parseLong(br.readLine());

            long i = n;
            while(true) {
                if(isPrime(i)) {
                    sb.append(i).append("\n");
                    break;
                }
                i++;
            }
        }

        System.out.println(sb);

        br.close();
    }

    private static boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;

        for(int i=3; i<=Math.sqrt(n); i+=2) {   // 홀수만 검사
            if(n % i == 0) return false;
        }

        return true;
    }
}