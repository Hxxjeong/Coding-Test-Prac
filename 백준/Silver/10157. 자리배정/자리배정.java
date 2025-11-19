import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int C, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        C = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);
        int K = Integer.parseInt(br.readLine());

        if(K > C*R) {
            System.out.println(0);
            return;
        }

        arr = new int[R][C];
        int end = C*R;
        int value = 1;
        int dir = 0;

        int x = R-1;
        int y = 0;
        arr[x][y] = value++;    // 시작점 설정
        while(value <= end) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C || arr[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                continue;
            }

            arr[nx][ny] = value++;
            x = nx;
            y = ny;
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j] == K) {
                    System.out.println((j+1) + " " + (R-i));
                    return;
                }
            }
        }

        br.close();
    }
}