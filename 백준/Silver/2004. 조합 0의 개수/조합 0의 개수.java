import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long n = Integer.parseInt(input[0]);
        long m = Integer.parseInt(input[1]);

        // 조합 = n! / ((n - m)! * m!)
        // 0이 나오려면 2와 5의 곱이 있어야 함

        // 2의 개수 = n!의 2의 개수 − m!의 2의 개수 − (n-m)!의 2의 개수
        long countTwo = countFactors(n, 2) - countFactors(m, 2) - countFactors(n - m, 2);
        // 5의 개수 = n!의 5의 개수 − m!의 5의 개수 − (n-m)!의 5의 개수
        long countFive = countFactors(n, 5) - countFactors(m, 5) - countFactors(n - m, 5);

        System.out.println(Math.min(countTwo, countFive));

        br.close();
    }

    // 소인수 k의 개수를 세는 메소드
    public static long countFactors(long num, long k) {
        long count = 0;
        while (num > 0) {
            num /= k;
            count += num;   // 몫을 더하면서 k가 몇 개 있는지 확인
        }
        return count;
    }
}