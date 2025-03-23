import java.io.*;

public class Main {
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);

        System.out.println(func());

        br.close();
    }

    public static int func() {
        int count = 1;

        while(B > A) {
            if(B % 2 == 0) B /= 2;  // 짝수면 2로 나누기
            else if(B % 10 == 1) B = (B - 1) / 10; // 끝자리가 1이면 제거
            else return -1; // 변환 불가능한 경우
            count++;
        }

        return A == B ? count : -1;
    }
}