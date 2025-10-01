import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        StringBuilder sb = new StringBuilder();
        while((input = br.readLine()) != null && !input.isEmpty()) {
            int n = Integer.parseInt(input);

            int mod = 1 % n;
            int len = 1;

            while(mod != 0) {
                mod = (mod * 10 + 1) % n;   // 나머지에 규칙이 존재하기 때문
                len++;
            }

            sb.append(len).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}