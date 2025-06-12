import java.io.*;

public class Main {
    // 우, 하, 우하, 우상
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[19][19];
        for(int i=0; i<19; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<19; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        for(int i=0; i<19; i++) {
            for(int j=0; j<19; j++) {
                if(arr[i][j] == 0) continue;

                int color = arr[i][j];
                for(int r=0; r<4; r++) {
                    int count = 1;
                    int x = i;
                    int y = j;
                    int nx = x + dx[r];
                    int ny = y + dy[r];

                    // 현재 방향의 이전 좌표를 확인해서 중복 제거 (시작점인지 확인)
                    int px = i - dx[r];
                    int py = j - dy[r];
                    if(px >= 0 && px < 19 && py >= 0 && py < 19 && arr[px][py] == color) continue;

                    while(nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && arr[nx][ny] == color) {
                        count++;
                        x = nx;
                        y = ny;
                        nx = x + dx[r];
                        ny = y + dy[r];
                    }

                    if(count == 5) {
                        System.out.println(color);
                        System.out.println((i+1) + " " + (j+1));
                        return;
                    }
                }
            }
        }

        System.out.println(0);

        br.close();
    }
}