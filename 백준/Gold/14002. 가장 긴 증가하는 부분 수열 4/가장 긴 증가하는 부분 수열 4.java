import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(input[i]);

        int[] dp = new int[N];
        Arrays.fill(dp, 1); // dp 배열 초기화

        int[] trace = new int[N];   // LIS 경로를 추적할 배열
        Arrays.fill(trace, -1);

        int maxLength = 1;  // LIS 길이 초기화 (첫번째 원소만 있을 때)
        int maxIndex = 0;   // LIS의 마지막 인덱스 (첫번쨰 원소로 초기화)

        for (int i=1; i<N; i++) {
            for (int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {  // i 이전의 모든 인덱스를 비교하여 큰 경우
                    // 이전의 부분 수열에 현재 원소를 추가했을 때 더 긴 부분 수열이 만들어질 수 있는지를 확인
                    if(dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;  // LIS 갱신
                        trace[i] = j;   // i로 끝나는 LIS가 j에서 이어지는 것 기록
                    }
                }
            }

            // 현재 인덱스의 LIS가 더 길 경우 LIS 길이와 인덱스 갱신
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                maxIndex = i;
            }
        }

        System.out.println(maxLength);   // LIS 길이

        // 백트래킹을 통해 LIS의 원소 추출
        Stack<Integer> stack = new Stack<>();   // 역순으로 원소를 모으기 위한 스택
        while(maxIndex != -1) {
            stack.push(arr[maxIndex]);  // LIS의 원소를 스택에 추가
            maxIndex = trace[maxIndex]; // 이전 원소로 이동
        }

        // LIS 출력
        while(!stack.isEmpty()) System.out.print(stack.pop() + " ");

        br.close();
    }
}