import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 카드의 개수

        int[] price = new int[N+1];     // 각 카드팩의 가격
        int[] dp = new int[N+1];    // 0부터 N까지의 카드 개수에 대한 최소 금액
        
        for(int i=1; i<=N; i++) dp[i] = Integer.MAX_VALUE;  // dp의 인덱스를 최대값으로 채움

        String[] input = br.readLine().split(" ");
        for(int i=1; i<=N; i++)
            price[i] = Integer.parseInt(input[i-1]);    // 0번 인덱스 사용 X

        for(int i=1; i<=N; i++) {   // 현재 구매하려는 카드 팩의 개수
            for(int j=1; j<=i; j++) {   // j개의 카드가 포함된 팩
                dp[i] = Math.min(dp[i], dp[i-j] + price[j]);
            }
        }

        System.out.println(dp[N]);

        br.close();
    }
}