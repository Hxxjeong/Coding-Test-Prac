import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        int left = Arrays.stream(arr).max().getAsInt();
        int right = Arrays.stream(arr).sum();
        int answer = right;
        while(left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int sum = 0;
            for(int i=0; i<N; i++) {
                if(sum + arr[i] > mid) {    // 인출 금액 초과 시 새로 인출
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if(count > M) left = mid+1;
            else {
                answer = mid;
                right = mid-1;
            }
        }

        System.out.println(answer);

        br.close();
    }
}