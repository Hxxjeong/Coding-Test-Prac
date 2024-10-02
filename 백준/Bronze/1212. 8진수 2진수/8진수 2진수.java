import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger binary = new BigInteger(br.readLine(), 8);

        System.out.println(binary.toString(2));

        br.close();
    }
}