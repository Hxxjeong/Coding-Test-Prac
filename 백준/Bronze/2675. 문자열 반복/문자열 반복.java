import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            String[] input = br.readLine().split(" ");
            int R = Integer.parseInt(input[0]);
            String S = input[1];

            for(char c: S.toCharArray()) {
                for(int j=0; j<R; j++) sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
