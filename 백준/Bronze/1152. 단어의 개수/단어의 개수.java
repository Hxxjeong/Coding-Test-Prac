import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        System.out.println(input[0].isEmpty() ? 0 : input.length);

        br.close();
    }
}