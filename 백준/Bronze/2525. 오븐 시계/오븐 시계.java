import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(br.readLine());

        A = A + ((B + C)/60);
        B = (B + C) % 60;

        System.out.println((A >= 24 ? A%24 : A) + " " + B);

        br.close();
    }
}