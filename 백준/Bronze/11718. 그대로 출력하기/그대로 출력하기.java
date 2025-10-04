import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        StringBuilder sb = new StringBuilder();
        while((input = br.readLine()) != null && !input.isEmpty()) {
            sb.append(input).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
