import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n이 1일 때 처리
        if(n == 1) {
            System.out.println(br.readLine());
            return;
        }

        List<int[]> list = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            list.add(new int[i+1]); // 0번 인덱스 사용 X
        }

        for(int i=1; i<=n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=1; j<=input.length; j++) {
                list.get(i)[j] = Integer.parseInt(input[j-1]);
            }
        }

        int[][] dp = new int[n+1][n+1];     // n번째 줄 n번 자리의 최대
        dp[1][1] = list.get(1)[1];  // 첫 번째 줄 1번 자리 최대
        dp[2][1] = list.get(1)[1] + list.get(2)[1];     // 두 번째 줄 1번 자리 (위의 원소가 1개뿐이므로 그냥 더함)
        dp[2][2] = list.get(1)[1] + list.get(2)[2];     // 두 번째 줄 2번 자리 (위의 원소가 1개뿐이므로 그냥 더함)

        // 현재 자신의 위치 + 윗 줄에서 뻣어나오는 두 가지 중 큰 값
        for(int i=3; i<=n; i++) {
            for(int j=1; j<list.get(i).length; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + list.get(i)[j];
            }
        }

        System.out.println(Arrays.stream(dp[n]).max().getAsInt());

        br.close();
    }
}