import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);     // 동생의 수
        int S = Integer.parseInt(input[1]);     // 수빈이의 현재 위

        String[] locations = br.readLine().split(" ");  // 동생의 위치
        long answer = Math.abs(S - Long.parseLong(locations[0])); // 초기 수빈이와 동생의 거리

        // 모든 동생과의 거리 차의 최대공약수
        for(int i=1; i<N; i++) {
            long diff = Math.abs(S - Long.parseLong(locations[i]));
            answer = gcd(answer, diff);  // 누적된 최대공약수와 현재 거리 차이의 최대공약수가 D가 됨
        }

        System.out.println(answer);

        br.close();
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}