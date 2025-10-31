import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] arr2 = new int[M][K];
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<K; j++) arr2[i][j] = Integer.parseInt(input[j]);
        }

        // C[i][j] = Σ(A[i][r] × B[r][j])
        int[][] answer = new int[N][K];
        for(int i=0; i<N; i++) {         // A의 행
            for(int j=0; j<K; j++) {     // B의 열
                for(int r=0; r<M; r++) { // A의 열 = B의 행
                    answer[i][j] += arr[i][r] * arr2[r][j];
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<K; j++) System.out.print(answer[i][j] + " ");
            System.out.println();
        }

        br.close();
    }
}
