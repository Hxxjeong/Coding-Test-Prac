import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int y = 0;
        int m = 0;

        for (int i = 0; i < N; i++) {
            int call = Integer.parseInt(input[i]);

            y += ((call / 30) + 1) * 10;
            m += ((call / 60) + 1) * 15;
        }

        if(y > m) System.out.println("M " + m);
        else if(y < m) System.out.println("Y " + y);
        else System.out.println("Y M " + y);

        br.close();
    }
}
