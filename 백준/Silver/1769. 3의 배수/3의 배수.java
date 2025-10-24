import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();

        int answer = 0;
        int sum = 0;
        while(X.length() > 1) {
            for(char c: X.toCharArray()) sum += c - '0';
            answer++;
            X = String.valueOf(sum);
            sum = 0;
        }

        System.out.println(answer);
        System.out.println(Integer.parseInt(X) % 3 == 0 ? "YES" : "NO");

        br.close();
    }
}