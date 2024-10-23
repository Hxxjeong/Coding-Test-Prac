import java.io.*;

public class Main {
    // 각 자리별 숫자가 몇 개 있는지
    static int[] number = {0, 9, 90, 900, 9_000, 90_000, 900_000, 9_000_000, 90_000_000, 1};

    // 각 자리별까지의 숫자의 합
    static int[] subSum = {0, 9, 99, 999, 9_999, 99_999, 999_999, 9_999_999, 99_999_999, 100_000_000};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long answer = 0;
        long length = String.valueOf(N).length();

        int i = 1;
        while(i < length) {
            answer += (long) number[i] * i;
            i++;
        }

        answer += (long) (N-subSum[i-1]) * i;

        System.out.println(answer);

        br.close();
    }
}