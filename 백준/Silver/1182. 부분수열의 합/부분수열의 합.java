import java.io.*;

public class Main {
    static int N, S;
    static int answer = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        String[] str = br.readLine().split(" ");
        arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(str[i]);

        // 부분 수열의 합 계산
        calculate(0, 0);

        // S가 0일 때 공집합을 제외하기 위해 1 감소
        if (S == 0) answer--;

        System.out.println(answer);

        br.close();
    }

    public static void calculate(int depth, int sum) {
        if (depth == N) {   // 전체 depth를 돌았을 때 합 확인
            if (sum == S) answer++;
            return;
        }

        // 현재 원소를 포함하지 않는 경우
        calculate(depth+1, sum);

        // 현재 원소를 포함하는 경우
        calculate(depth+1, sum + arr[depth]);
    }
}