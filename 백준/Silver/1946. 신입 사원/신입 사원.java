import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][2];
            for(int i=0; i<N; i++) {
                String[] input = br.readLine().split(" ");
                for(int j=0; j<2; j++) arr[i][j] = Integer.parseInt(input[j]);
            }

            Arrays.sort(arr, (a, b) -> a[0] - b[0]);
            int min = Integer.MAX_VALUE;
            int answer = 0;

            // 이전 참가자보다 순위가 높으면 선발
            for(int i=0; i<N; i++) {
                if(arr[i][1] < min) {
                    min = arr[i][1];
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
