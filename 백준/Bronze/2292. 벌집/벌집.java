import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int layer = 1; // 현재 층
        int range = 1; // 현재 층의 마지막 숫자

        // 범위가 N을 포함할 때까지 층을 증가
        while(range < N) {
            range += 6 * layer; // 각 층에서 6 * 층번호만큼 숫자가 증가
            layer++;
        }

        System.out.println(layer);
        br.close();
    }
}
