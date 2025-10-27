import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int N = Integer.parseInt(input[2]);

        int remainder = A % B;  // 처음 나머지
        int answer = 0;

        for(int i=0; i<N; i++) {
            remainder *= 10;
            answer = remainder / B;
            remainder %= B;
        }

        System.out.println(answer);

        br.close();
    }
}