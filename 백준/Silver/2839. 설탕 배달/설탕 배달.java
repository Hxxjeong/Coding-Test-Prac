import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        while(N >= 0) {
            // 5kg로 나눠떨어지는 경우
            if(N % 5 == 0) {
                count += N / 5;
                System.out.println(count);
                return;
            }

            // 5kg로 나눠떨어지지 않으면 3kg 봉지 하나 사용
            N -= 3;
            count++;
        }

        // 정확히 나눌 수 없는 경우
        System.out.println(-1);
        br.close();
    }
}
