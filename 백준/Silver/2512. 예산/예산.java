import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(input[i]);
        Arrays.sort(arr);

        int left = 0;
        int right = arr[N-1];
        int answer = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for(int i: arr) sum += Math.min(i, mid);

            // 합이 가능한 경우 상한선 높이기
            if(sum <= M) {
                answer = mid;
                left = mid + 1;
            }
            else right = mid - 1;   // 예산 초과 시 상한선 낮추기
        }

        System.out.println(answer);

        br.close();
    }
}
