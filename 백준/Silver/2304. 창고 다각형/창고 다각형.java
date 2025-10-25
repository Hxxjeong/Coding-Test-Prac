import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));   // 위치 기준 정렬

        int maxH = 0, maxIdx = 0;
        for(int i=0; i<N; i++) {
            if(arr[i][1] > maxH) {
                maxH = arr[i][1];
                maxIdx = i;
            }
        }

        int answer = 0;

        // 왼쪽 구간
        int leftPos = arr[0][0];
        int leftMax = arr[0][1];
        for(int i=1; i <= maxIdx; i++) {
            if(arr[i][1] > leftMax) {
                answer += (arr[i][0] - leftPos) * leftMax;
                leftPos = arr[i][0];
                leftMax = arr[i][1];
            }
        }

        // 오른쪽 구간
        int rightPos = arr[N-1][0];
        int rightMax = arr[N-1][1];
        for(int i=N-2; i>=maxIdx; i--) {
            if(arr[i][1] >= rightMax) {
                answer += (rightPos - arr[i][0]) * rightMax;
                rightPos = arr[i][0];
                rightMax = arr[i][1];
            }
        }

        answer += maxH;

        System.out.println(answer);

        br.close();
    }
}