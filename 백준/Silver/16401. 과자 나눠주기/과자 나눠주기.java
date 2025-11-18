import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = Arrays.stream(arr).max().getAsInt();

        int left = 1;
        int right = max;
        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;   // 가능한 과자 길이

            long count = 0; // 나눌 수 있는 사람 수
            for(int i: arr) count += i / mid;

            if(count >= M) {    // 더 크게 만들 수 있는 경우
                answer = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        System.out.println(answer);

        br.close();
    }
}