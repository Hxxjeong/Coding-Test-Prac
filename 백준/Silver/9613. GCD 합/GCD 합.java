import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            long answer = 0;
            String[] input = br.readLine().split(" ");
            long n = Long.parseLong(input[0]);

            for(int j=1; j<=n; j++) {
                for(int k=j+1; k<=n; k++) {
                    answer += gcd(Long.parseLong(input[j]), Long.parseLong(input[k]));
                }
            }

            System.out.println(answer);
        }

        br.close();
    }

    public static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}