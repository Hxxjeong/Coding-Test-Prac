import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String input = br.readLine();
        for(String s: arr) input = input.replaceAll(s, "0");

        System.out.println(input.length());

        br.close();
    }
}
