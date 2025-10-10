import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<N; i++) {
            String str = String.valueOf(i);
            int num = i;
            for(char c: str.toCharArray()) num += c - '0';

            if(num == N) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);

        br.close();
    }
}
