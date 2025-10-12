import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        
        long gcd = gcd(Math.max(a, b), Math.min(a, b));

        System.out.println(a * b / gcd);

        br.close();
    }
    
    static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
