import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[n+1];   // 0번 인덱스 사용 X
        for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(input[i-1]);

        int[] noSkip = new int[n+1];    // 일반적인 연속합
        int[] skip = new int[n+1];      // 숫자를 건너뛸 때의 최대 연속합

        noSkip[1] = arr[1];
        skip[1] = 0;

        int answer = arr[1];
        for(int i=2; i<=n; i++) {
            noSkip[i] = Math.max(arr[i], noSkip[i-1] + arr[i]);
            skip[i] = Math.max(arr[i] + skip[i-1], noSkip[i-1]);  // i-1을 제외한 경우와 본인을 제외할 때 비교
            answer = Math.max(answer, Math.max(noSkip[i], skip[i]));
        }

        System.out.println(answer);

        br.close();
    }
}