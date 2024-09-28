import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);

        System.out.println(gcd(num1, num2));    // 최대공약수
        System.out.println(num1 * num2 / gcd(num1, num2));  // 최소공배수 (둘의 곱 / 최대공약수)

        br.close();
    }

    // 유클리드 호제법을 사용하여 최대공약수를 구하는 메소드
    public static int gcd(int num1, int num2) {
        /*
            1. 두 수 A와 B (A > B)의 최대공약수는 A를 B로 나눈 나머지를 r라고 할 때, A와 B의 최대공약수는 B와 r의 최대공약수와 동일
            2. 즉, gcd(A, B) = gcd(B, A % B)
            3. 이 과정을 나머지가 0이 될 때까지 반복하면, 그때의 나누는 수가 두 수의 최대공약수
         */
        if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }
}