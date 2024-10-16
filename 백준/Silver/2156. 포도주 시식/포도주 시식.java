import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];   // 0번 인덱스 사용 X
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 한 잔이거나 두 잔인 경우 바로 출력
        if(n == 1){
            System.out.println(arr[1]);
            return;
        }

        if(n == 2) {
            System.out.println(arr[2] + arr[1]);
            return;
        }

        // 생각할 수 있는 경우의 수 (연속 세 잔 불가)
        // 1. 현재 잔 O, 이전 잔 X, 전전 잔 O
        // 2. 현재 잔 O, 이전 잔 O, 전전 잔 X
        // 3. 현재 잔 X (이전 상태 그대로 유지)
        // 이 세 가지 중 최대
        int[] dp = new int[n+1];    //  0번 인덱스 사용 X
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        
        for(int i=3; i<=n; i++) {
            // 1~3 조건 순서대로
            dp[i] = Math.max(arr[i] + dp[i-2], Math.max(arr[i] + arr[i-1] + dp[i-3], dp[i-1]));
        }

        System.out.println(dp[n]);

        br.close();
    }
}