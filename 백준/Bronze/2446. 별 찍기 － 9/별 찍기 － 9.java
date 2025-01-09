import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) sb.append(" ");
            for(int j=2*(N-i)-1; j>0; j--) sb.append("*");

            sb.append("\n");
        }

        for(int i=1; i<N; i++) {
            for(int j=N-i; j>1; j--) sb.append(" ");
            for(int j=0; j<=2*i; j++) sb.append("*");

            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
