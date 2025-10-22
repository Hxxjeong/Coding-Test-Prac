import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int jimin = Integer.parseInt(input[1]);
        int hansoo = Integer.parseInt(input[2]);

        int answer = 0;
        int a = jimin-1;
        int b = hansoo-1;
        while(a != b) { // 몫이 같으면 같은 라운드
            a /= 2;
            b /= 2;
            answer++;
        }

        System.out.println(answer);

        br.close();
    }
}