import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] radix = br.readLine().split(" ");
        int A = Integer.parseInt(radix[0]);
        int B = Integer.parseInt(radix[1]);

        int m = Integer.parseInt(br.readLine());    // A진법 숫자 자릿수의 개수

        String[] input = br.readLine().split(" ");  // 각 자릿수 별 숫자
        int numA = 0;

        // A진법 to 10진법
        for(int i=0; i<m; i++) {
            numA += Integer.parseInt(input[i]) * (int) Math.pow(A, m-1-i);
        }

        // 10진법 to B진법
        StringBuilder sb = new StringBuilder();
        while(numA != 0) {
            sb.append(numA % B).append(" ");
            numA /= B;
        }

        String[] answer = sb.delete(sb.length()-1, sb.length()).toString().split(" ");  // 제일 뒤의 공백 제거

        // 출력
        for(int i=answer.length-1; i>=0; i--) {
            System.out.print(answer[i] + " ");
        }

        br.close();
    }
}