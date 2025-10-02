import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N+1][M+1];
        int[][] sums = new int[N+1][M+1];   // 부분합 배열
        for(int i=1; i<=N; i++) {
            input = br.readLine().split(" ");
            for(int j=1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(input[j-1]);
                sums[i][j] = arr[i][j] + sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int k=0; k<K; k++) {
            input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);

            int sum = sums[x][y] - sums[i-1][y] - sums[x][j-1] + sums[i-1][j-1];

            sb.append(sum).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}