import java.io.*;

public class Main {
    static int[] arr = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 카드의 개수

        int[] price = new int[N+1];     // 각 카드팩의 가격
        int[] dp = new int[N+1];    // 0부터 N까지의 카드 개수에 대한 최대 금액

        String[] input = br.readLine().split(" ");
        for(int i=1; i<=N; i++)
            price[i] = Integer.parseInt(input[i-1]);    // 0번 인덱스 사용 X

        // 5 2 8 10 일 때
        // dp는 5 10 15 20 (각 1장, 2장, 3장, 4장을 사는 최대 개수)
        for(int i=1; i<=N; i++) {   // 현재 구매하려는 카드 팩의 개수
            for(int j=1; j<=i; j++) {   // j개의 카드가 포함된 팩
                dp[i] = Math.max(dp[i], dp[i-j] + price[j]);
            }
        }

        System.out.println(dp[N]);

        br.close();
    }
}