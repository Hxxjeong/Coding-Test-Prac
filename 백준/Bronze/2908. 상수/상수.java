import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        StringBuilder A = new StringBuilder(input[0]);
        StringBuilder B = new StringBuilder(input[1]);

        int a = Integer.parseInt(A.reverse().toString());
        int b = Integer.parseInt(B.reverse().toString());

        System.out.println(Math.max(a, b));

        br.close();
    }
}
