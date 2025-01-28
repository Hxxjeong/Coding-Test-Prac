import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        // N의 마지막 두 자리를 00으로 초기화
        int n = (N / 100) * 100;

        // 나누어떨어지는 값을 찾기
        while(n % F != 0) n++;

        int answer = n % 100;
        System.out.printf("%02d", answer);

        br.close();
    }
}
