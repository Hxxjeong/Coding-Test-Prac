import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String str = "long ";
        str = str.repeat(N/4);
        str += "int";

        System.out.println(str);

        br.close();
    }
}