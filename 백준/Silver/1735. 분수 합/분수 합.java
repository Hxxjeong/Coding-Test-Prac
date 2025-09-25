import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int numA = Integer.parseInt(input[0]);
        int denA = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int numB = Integer.parseInt(input[0]);
        int denB = Integer.parseInt(input[1]);

        int numAnswer = numA * denB + numB * denA;
        int denAnswer = denA * denB;

        int n = gcd(numAnswer, denAnswer);
        System.out.println(numAnswer/n + " " + denAnswer/n);

        br.close();
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}