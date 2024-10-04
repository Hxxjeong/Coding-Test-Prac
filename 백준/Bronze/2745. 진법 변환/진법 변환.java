import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int B = Integer.parseInt(input[1]);

        System.out.println(Integer.parseInt(input[0], B));

        br.close();
    }
}