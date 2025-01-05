import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int diagonal = 1;   // 대각선 위치
        int denominatorSum = 0;     // 분모의 합

        // 대각선 번호 찾기
        while(denominatorSum + diagonal < X) {
            denominatorSum += diagonal;
            diagonal++;
        }

        int index = X - denominatorSum; // 대각선 내에서의 위치 (해당 대각선에서 몇 번째에 위치하는지)
        int numerator;      // 분자
        int denominator;    // 분모

        // 홀수 대각선 (분자 감소, 분모 증가)
        if(diagonal % 2 == 1) {
            numerator = diagonal - index + 1;
            denominator = index;
        }
        // 짝수 대각선 (분자 증가, 분모 감소)
        else {
            numerator = index;
            denominator = diagonal - index + 1;
        }

        System.out.println(numerator + "/" + denominator);
        br.close();
    }
}
