import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n+1];  // 0번 인덱스 제외
            int[][] dp = new int[2][n+1];   // 0번 인덱스 제외

            for(int j=0; j<2; j++) {
                String[] input = br.readLine().split(" ");
                for(int k=1; k<=n; k++) {
                    sticker[j][k] = Integer.parseInt(input[k-1]);
                }
            }

            // 초기화
            dp[0][1] = sticker[0][1];   // 첫 번째 줄 위쪽 스티커
            dp[1][1] = sticker[1][1];   // 첫 번째 줄 아래쪽 스티커

            // 현재 열을 포함할 때 최대 + 이전 줄에서 선택한 스티커의 최대 계산
            // j-2 열의 스티커를 선택하는 경우도 고려 (문제의 입력 예시 상황)
            for (int j=2; j<=n; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + sticker[0][j];  // 위 스티커 선택
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + sticker[1][j];  // 아래 스티커 선택
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }

        br.close();
    }
}