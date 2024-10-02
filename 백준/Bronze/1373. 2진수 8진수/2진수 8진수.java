import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger binary = new BigInteger(br.readLine(), 2);

        System.out.println(binary.toString(8));

        br.close();
    }
}