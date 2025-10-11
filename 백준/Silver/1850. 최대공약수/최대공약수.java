import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        long a = Math.max(A, B);
        long b = Math.min(A, B);
        long gcd = gcd(a, b);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<gcd; i++) sb.append("1");

        System.out.println(sb);

        br.close();
    }

    public static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
