import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N+1];   // 0번 인덱스 사용 X
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(input[i-1]);

        int[] dpUp = new int[N+1];  // 증가하는 부분 수열
        int[] dpDown = new int[N+1];    // 감소하는 부분 수열

        // 증가하는 부분 수열
        for(int i=1; i<=N; i++) {
            dpUp[i] = 1;
            for(int j=1; j<i; j++) {
                if(arr[i] > arr[j]) {
                    dpUp[i] = Math.max(dpUp[i], dpUp[j]+1); // LIS 계산 (현재 인덱스보다 전의 인덱스를 살피면서 자신보다 작을 때 +1
                }
            }
        }

        // 감소하는 부분 수열 (역순)
        for(int i=N; i>=1; i--) {
            dpDown[i] = 1;
            for(int j=N; j>i; j--) {
                if(arr[i] > arr[j]) {
                    dpDown[i] = Math.max(dpDown[i], dpDown[j]+1);   // LDS 계산 (현재 인덱스보다 이후의 인덱스를 살피면서 자신보다 작을 때 +1)
                }
            }
        }

        // 바이토닉 수열
        int answer = 0;
        for(int i=1; i<=N; i++) {
            answer = Math.max(answer, dpUp[i] + dpDown[i] - 1); // 본인이 중복되므로 -1
        }

        System.out.println(answer);

        br.close();
    }
}