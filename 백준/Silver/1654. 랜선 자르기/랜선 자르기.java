import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] arr = new int[K];
        int max = 0;
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max;
        long answer = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            // mid 길이로 잘랐을 때 만들 수 있는 랜선 개수
            for(int i=0; i<K; i++) count += (arr[i] / mid);

            // 랜선 개수를 충족한 경우
            if(count >= N) {
                answer = mid;
                left = mid + 1; // 더 긴 길이 시도
            }
            else right = mid - 1; // 더 짧은 길이 시도
        }

        System.out.println(answer);

        br.close();
    }
}
