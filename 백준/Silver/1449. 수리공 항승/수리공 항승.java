import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int answer = 1;
        double end = arr[0] - 0.5 + L;  // 첫번째 테이프의 끝
        for(int i=1; i<N; i++) {
            if(arr[i] + 0.5 > end) {    // 테이프가 더 필요한 경우
                answer++;
                end = arr[i] - 0.5 + L;
            }
        }

        System.out.println(answer);

        br.close();
    }
}