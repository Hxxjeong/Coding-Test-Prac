import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(char c: input.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                sb.append((char) ((c - 'a' + 13) % 26 + 'a'));
            else if (c >= 'A' && c <= 'Z')
                sb.append((char) ((c - 'A' + 13) % 26 + 'A'));
            else
                sb.append(c);
        }

        System.out.println(sb);

        br.close();
    }
}