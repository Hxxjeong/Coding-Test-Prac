import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(input[i]);

        int[] dp = new int[N];
        Arrays.fill(dp, 1); // dp 배열 초기화

        for (int i=1; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j])  // i 이전의 모든 인덱스를 비교하여 큰 경우
                    dp[i] = Math.max(dp[i], dp[j]+1);     // 이전과 현재 인덱스까지의 부분 수열과 비교
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

        br.close();
    }
}

/*
arr = [10, 20, 10, 30, 20, 50] 일 때

i = 1 (arr[1] = 20):
j = 0 (arr[0] = 10): arr[1] > arr[0] 이므로, dp[1] = dp[0] + 1 = 2
dp = [1, 2, 1, 1, 1, 1]

i = 2 (arr[2] = 10):
j = 0, j = 1: arr[2]는 arr[0] 및 arr[1]보다 작으므로 갱신 X
dp = [1, 2, 1, 1, 1, 1]

i = 3 (arr[3] = 30):
j = 0 (arr[0] = 10): arr[3] > arr[0] 이므로, dp[3] = dp[0] + 1 = 2
j = 1 (arr[1] = 20): arr[3] > arr[1] 이므로, dp[3] = dp[1] + 1 = 3
j = 2 (arr[2] = 10): arr[3] > arr[2]이지만, 이미 dp[3]이 3이므로 변화 X
dp = [1, 2, 1, 3, 1, 1]

i = 4 (arr[4] = 20):
j = 0 (arr[0] = 10): arr[4] > arr[0] 이므로, dp[4] = dp[0] + 1 = 2
j = 1 (arr[1] = 20): arr[4] == arr[1] 이므로 갱신 X
j = 2 (arr[2] = 10): arr[4] > arr[2] 이므로, dp[4] = dp[2] + 1 = 2
j = 3 (arr[3] = 30): arr[4] < arr[3] 이므로 갱신 X
dp = [1, 2, 1, 3, 2, 1]

i = 5 (arr[5] = 50):
j = 0 (arr[0] = 10): arr[5] > arr[0] 이므로, dp[5] = dp[0] + 1 = 2
j = 1 (arr[1] = 20): arr[5] > arr[1] 이므로, dp[5] = dp[1] + 1 = 3
j = 2 (arr[2] = 10): arr[5] > arr[2] 이므로, dp[5] = dp[2] + 1 = 2
j = 3 (arr[3] = 30): arr[5] > arr[3] 이므로, dp[5] = dp[3] + 1 = 4
j = 4 (arr[4] = 20): arr[5] > arr[4] 이므로, dp[5] = dp[4] + 1 = 3
dp = [1, 2, 1, 3, 2, 4]

LIS는 dp의 최댓값
 */