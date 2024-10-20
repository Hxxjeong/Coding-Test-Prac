import java.io.*;

public class Main {
    static final int EARTH = 15;
    static final int SUN = 28;
    static final int MOON = 19;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int E = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);

        E = (E == 15) ? 0 : E;
        S = (S == 28) ? 0 : S;
        M = (M == 19) ? 0 : M;

        int answer = E;  // E부터 시작
        if (answer == 0) answer = 15;  // E가 0이면 시작점을 15로 맞춰줌

        while (true) {
            // 어떤 수를 E, S, M으로 나눴을 때 나머지가 입력으로 주어진 수
            if (answer % SUN == S && answer % MOON == M) {
                System.out.println(answer);
                break;
            }
            answer += EARTH;
        }

        br.close();
    }
}