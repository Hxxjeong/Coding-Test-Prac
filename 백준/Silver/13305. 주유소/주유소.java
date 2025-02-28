import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] road = new long[N-1];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N-1; i++) road[i] = Long.parseLong(input[i]);

        long[] city = new long[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++) city[i] = Long.parseLong(input[i]);

        long minPrice = city[0]; // 현재까지의 최소 주유 가격
        long answer = 0;
        for(int i=0; i<N-1; i++) {
            minPrice = Math.min(minPrice, city[i]); // 최소 가격 갱신
            answer += minPrice * road[i]; // 최소 가격으로 주유
        }

        System.out.println(answer);

        br.close();
    }
}
