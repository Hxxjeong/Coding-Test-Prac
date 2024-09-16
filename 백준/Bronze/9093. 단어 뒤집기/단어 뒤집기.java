import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 명령 개수

        for(int i=0; i<T; i++) {
            String[] input = br.readLine().split(" ");

            StringBuilder result = new StringBuilder();
            for(int j=0; j<input.length; j++) {
                StringBuilder origin = new StringBuilder(input[j]);
                result.append(origin.reverse()).append(" ");
            }

            System.out.println(result);
        }

        br.close();
    }
}