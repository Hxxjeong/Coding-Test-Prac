import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            String[] input = br.readLine().split(" ");
            int H = Integer.parseInt(input[0]); // 호텔 층수
            int N = Integer.parseInt(input[2]); // N번째 손님

            // 층
            int YY = N % H;
            if (YY == 0) YY = H; // N이 H의 배수일 경우 꼭대기 층

            // 방 번호
            int XX = (N - 1) / H + 1;

            // 방 번호 두 자리로 출력
            System.out.printf("%d%02d\n", YY, XX);
        }

        br.close();
    }
}