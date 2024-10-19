import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] rgb = new int[N+1][3];
        for(int i=1; i<=N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<3; j++) {
                rgb[i][j] = Integer.parseInt(input[j]);
            }
        }

        int infinity = 1000 * 1000 + 1; // 최댓값을 벗어나는 값 (집 1000개, 칠하는 비용 1000 최대)

        int answer = infinity;

        answer = Math.min(answer, calColor(N, rgb, 0, infinity)); // 첫번째 집이 빨간색
        answer = Math.min(answer, calColor(N, rgb, 1, infinity)); // 첫번째 집이 초록색
        answer = Math.min(answer, calColor(N, rgb, 2, infinity)); // 첫번째 집이 파란색

        System.out.println(answer);

        br.close();
    }

    public static int calColor(int N, int[][] rgb, int firstColor, int infinity) {
        int[][] dp = new int[N+1][3];

        // 첫 번째 집 고정
        for (int i = 0; i < 3; i++) {
            if (i == firstColor) dp[1][i] = rgb[1][i]; // 첫 번째 집 색상 고정 (빨간색, 초록색, 파란색)
            else dp[1][i] = infinity; // 나머지 색상은 선택 불가
        }

        for(int i=2; i<=N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];    // 이전의 집이 초록색 or 파란색
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];    // 이전의 집이 빨간색 or 파란색
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];    // 이전의 집이 빨간색 or 초록색
        }

        int min = infinity;

        // 마지막 집은 첫번째 집과 색이 달라야 함
        for(int i=0; i<3; i++) {
            if(i != firstColor) min = Math.min(min, dp[N][i]);
        }

        return min;
    }
}