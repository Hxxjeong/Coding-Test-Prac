import java.io.*;
import java.util.*;

public class Main {
    // queen
    static int[] qx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] qy = {1, -1, 0, 0, 1, -1, 1, -1};

    // knight
    static int[] kx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] ky = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        char[][] chess = new char[n][m];
        for(int i=0; i<n; i++) Arrays.fill(chess[i], 'O');  // 초기화

        // queen 위치
        StringTokenizer queen = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(queen.nextToken());
        List<int[]> queens = new ArrayList<>();
        for (int i=0; i<q; i++) {
            int x = Integer.parseInt(queen.nextToken()) - 1;
            int y = Integer.parseInt(queen.nextToken()) - 1;
            chess[x][y] = 'Q';
            queens.add(new int[]{x, y});
        }

        // knight 위치
        StringTokenizer knight = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(knight.nextToken());
        List<int[]> knights = new ArrayList<>();
        for (int i=0; i<k; i++) {
            int x = Integer.parseInt(knight.nextToken()) - 1;
            int y = Integer.parseInt(knight.nextToken()) - 1;
            chess[x][y] = 'K';
            knights.add(new int[]{x, y});
        }

        // pawn 위치
        StringTokenizer pawn = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(pawn.nextToken());
        for(int i=0; i<p; i++) {
            int x = Integer.parseInt(pawn.nextToken()) - 1;
            int y = Integer.parseInt(pawn.nextToken()) - 1;
            chess[x][y] = 'P';
        }

        // queen 이동 처리
        for (int[] qq: queens) {
            for (int i=0; i<8; i++) {
                int nx = qq[0];
                int ny = qq[1];
                while (true) {
                    nx += qx[i];
                    ny += qy[i];

                    // 경계이거나 이미 말이 존재하는 경우 건너뛰기
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || chess[nx][ny] == 'Q' || chess[nx][ny] == 'P' || chess[nx][ny] == 'K') break;

                    chess[nx][ny] = 'X';  // 안전하지 않은 칸 표시
                }
            }
        }

        // knight 이동 처리
        for (int[] kk: knights) {
            for (int i=0; i<8; i++) {
                int nx = kk[0] + kx[i];
                int ny = kk[1] + ky[i];

                // 경계가 아닌 거나 말이 없는 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && chess[nx][ny] == 'O')
                    chess[nx][ny] = 'X';  // 안전하지 않은 칸 표시
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(chess[i][j] == 'O') answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}