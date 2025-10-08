import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int left = 1, right = 1;
        int sum = 1;
        int answer = 0;
        while(right <= N) {
            if(sum == N) {
                answer++;

                // 다음 구간 탐색
                sum -= left;
                left++;
            }
            else if(sum < N) {
                right++;
                sum += right;
            }
            else if(sum > N) {
                sum -= left;
                left++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
