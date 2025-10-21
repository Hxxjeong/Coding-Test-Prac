import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int w = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int p = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);

        int t = Integer.parseInt(br.readLine());

        int nx = (p + t) % (2 * w); // 시작 위치 + 걸리는 시간 / 주기 (w 왕복)
        int ny = (q + t) % (2 * h);

        if(nx > w) nx = 2 * w - nx;    // 벽 반사 고려
        if(ny > h) ny = 2 * h - ny;

        System.out.println(nx + " " + ny);
    }
}