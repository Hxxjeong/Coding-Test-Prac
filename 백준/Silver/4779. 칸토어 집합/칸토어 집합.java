import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        StringBuilder sb = new StringBuilder();
        while((input = br.readLine()) != null && !input.isEmpty()) {
            sb.append(func(Integer.parseInt(input))).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static String func(int n) {
        if (n == 0) return "-";

        String prev = func(n-1);
        String space = " ".repeat((int) Math.pow(3, n-1));
        return prev + space + prev;
    }
}