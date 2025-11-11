import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] count = new int[100_001]; // 각 숫자가 몇 번 나왔는지
        int left = 0;
        int right = 0;
        int answer = 0;

        while(right < N) {
            count[arr[right]]++;

            while(count[arr[right]] > K) {
                count[arr[left]]--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
            right++;
        }

        System.out.println(answer);

        br.close();
    }
}