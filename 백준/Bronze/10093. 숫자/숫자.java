import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        if(A > B) {
            long temp = A;
            A = B;
            B = temp;
        }

        System.out.println(A==B ? 0 : B-A-1);

        StringBuilder sb = new StringBuilder();
        for(long i=A+1; i<B; i++) sb.append(i).append(" ");

        System.out.println(sb);

        br.close();
    }
}
