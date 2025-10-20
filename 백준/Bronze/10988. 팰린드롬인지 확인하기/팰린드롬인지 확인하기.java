import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String reverse = new StringBuilder(input).reverse().toString();

        System.out.println(reverse.equals(input) ? 1 : 0);

        br.close();
    }
}