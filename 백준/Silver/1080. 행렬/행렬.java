import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] a = new int[N][M];
        int[][] b = new int[N][M];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) a[i][j] = line.charAt(j) - '0';
        }

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) b[i][j] = line.charAt(j) - '0';
        }

        int answer = 0;
        for(int i=0; i<=N-3; i++) {
            for(int j=0; j<=M-3; j++) {
                if(a[i][j] != b[i][j]) {
                    flip(a, i, j);  // 3*3 뒤집기
                    answer++;
                }
            }
        }

        if(Arrays.deepEquals(a, b)) System.out.println(answer);
        else System.out.println(-1);

        br.close();
    }

    public static void flip(int[][] a, int x, int y) {
        for(int i=x; i<x+3; i++) {
            for(int j=y; j<y+3; j++) {
                a[i][j] = 1 - a[i][j];
            }
        }
    }
}