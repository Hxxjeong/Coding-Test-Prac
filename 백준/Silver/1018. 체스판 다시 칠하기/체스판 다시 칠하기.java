import java.io.*;

public class Main {
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static char[][] chess;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        chess = new char[N][M];
        for(int i=0; i<N; i++) {
            String chInput = br.readLine();
            for(int j=0; j<M; j++) chess[i][j] = chInput.charAt(j);
        }

        // 8x8 크기로 잘라서 탐색
        for(int i=0; i<=N-8; i++) {
            for(int j=0; j<=M-8; j++) {
                calculate(i, j);    // 시작 좌표
            }
        }

        System.out.println(min);

        br.close();
    }

    public static void calculate(int n, int m) {
        int repaintB = 0; // B로 시작하는 경우의 칠하는 횟수
        int repaintW = 0; // W로 시작하는 경우의 칠하는 횟수

        // 8x8 크기 탐색
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                char current = chess[n+i][m+j];

                if ((i+j) % 2 == 0) { // 시작 위치와 색이 같아야 하는 경우
                    if (current != 'B') repaintB++; // 시작 위치가 B인데 다른 경우
                    if (current != 'W') repaintW++; // 시작 위치가 W인데 다른 경우
                }
                else { // 시작 위치와 색이 달라야 하는 경우
                    if (current != 'W') repaintB++; // 시작 위치가 B인데 같은 경우
                    if (current != 'B') repaintW++; // 시작 위치가 W인데 같은 경우
                }
            }
        }

        // 두 가지 경우 중 최소 칠해야 하는 횟수 선택
        min = Math.min(min, Math.min(repaintB, repaintW));
    }
}