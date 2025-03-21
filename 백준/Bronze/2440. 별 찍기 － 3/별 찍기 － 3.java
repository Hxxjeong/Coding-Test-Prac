import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=N-i; j>0; j--) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
