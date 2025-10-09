import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        // 총 비용 < 총 수입 (A+B*n < C*n) = (A/(C-B) < n)
        if(B >= C) System.out.println(-1);
        else System.out.println((A / (C-B)) + 1);

        br.close();
    }
}
