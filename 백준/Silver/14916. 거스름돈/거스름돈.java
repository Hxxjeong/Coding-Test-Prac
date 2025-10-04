import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        while(n >= 0) {
            if(n % 5 == 0) {
                answer += n / 5;
                System.out.println(answer);
                return;
            }
            n -= 2;     // 5로 나누어지지 않으면 2씩 빼서 계산
            answer++;
        }

        System.out.println(-1);

        br.close();
    }
}
