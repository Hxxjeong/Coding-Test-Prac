import java.io.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] isHorizon; // 가로/세로 묶기 = t/f
    static int maxSum = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 세로
        M = Integer.parseInt(input[1]); // 가로

        arr = new int[N][M];
        isHorizon = new boolean[N][M];
        for (int i=0; i<N; i++) {
            String[] num = br.readLine().split("");
            for (int j=0; j<M; j++) arr[i][j] = Integer.parseInt(num[j]);
        }

        dfs(0, 0);
        System.out.println(maxSum);

        br.close();
    }

    public static void dfs(int x, int y) {
        // 모든 종이를 다 조각냈을 때
        if (x == N) {
            maxSum = Math.max(maxSum, calculate());
            return;
        }

        // 다음 행으로 이동
        if (y == M) {
            dfs(x+1, 0);
            return;
        }

        // 현재 칸을 가로로 묶음
        isHorizon[x][y] = true;
        dfs(x, y+1);

        // 현재 칸을 세로로 묶음
        isHorizon[x][y] = false;
        dfs(x, y+1);
    }

    // 가로/세로로 묶인 숫자의 합 계산
    public static int calculate() {
        int sum = 0;

        // 가로 숫자 계산
        for(int i=0; i<N; i++) {
            int rowSum = 0;
            for(int j=0; j<M; j++) {
                if(isHorizon[i][j]) rowSum = rowSum * 10 + arr[i][j];
                else {
                    sum += rowSum;
                    rowSum = 0;
                }
            }
            sum += rowSum;
        }

        // 세로 숫자 계산
        for(int i=0; i<M; i++) {
            int colSum = 0;
            for(int j=0; j<N; j++) {
                if(!isHorizon[j][i]) colSum = colSum * 10 + arr[j][i];
                else {
                    sum += colSum;
                    colSum = 0;
                }
            }
            sum += colSum;
        }

        return sum;
    }
}