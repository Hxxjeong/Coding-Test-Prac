import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while(!(input = br.readLine()).equals("0")) {
            StringBuilder sb = new StringBuilder();
            sb.append(input).append(" ");

            int sum = 1;
            while(input.length() > 1) {
                for(char c: input.toCharArray()) {
                    sum *= (c - '0');
                }
                input = String.valueOf(sum);
                sb.append(input).append(" ");
                sum = 1;
            }
            System.out.println(sb);
        }

        br.close();
    }
}
