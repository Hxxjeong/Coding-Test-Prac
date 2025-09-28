import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int left = Arrays.stream(arr).max().getAsInt(); // 최소 강의 길이 (가장 긴 강의 길이)
        int right = Arrays.stream(arr).sum();   // 최대 강의 길이 (모든 강의의 합)
        int answer = right;
        while(left <= right) {
            int mid = (left + right) / 2;

            int count = getCount(arr, mid); // 필요한 블루레이 개수
            // 블루레이 개수가 더 적은 경우 최대 용량을 더 늘릴 수 있음
            if(count <= M) {
                answer = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }

        System.out.println(answer);

        br.close();
    }

    private static int getCount(int[] arr, int size) {
        int count = 1;
        int sum = 0;

        for(int i: arr) {
            if (sum + i > size) {
                count++;        // 새 블루레이 필요
                sum = i;      // 현재 강의부터 시작
            }
            else sum += i;
        }

        return count;
    }
}