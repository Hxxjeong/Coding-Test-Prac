import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int r = 1;
            // 각 숫자의 거듭제곱에 대해 일의 자리 숫자 주기가 있음
            /*
                1 = 1만 반복
                2 = 2, 4, 8, 6 반복
                3 = 3, 9, 7, 1 반복
                4 = 4, 6 반복
                5 = 5만 반복
                6 = 6만 반복
                7 = 7, 9, 3, 1 반복
                8 = 8, 6 반복
                9 = 9, 1 반복
             */
            // b제곱이므로 b만큼 반복해서 일의 자리를 구함
            for(int j=0; j<b; j++) {
                r = (r*a) % 10;
            }
            
            System.out.println(r == 0 ? 10 : r);    // 일의 자리 0일 때 10번 컴퓨터
        }

        br.close();
    }
}