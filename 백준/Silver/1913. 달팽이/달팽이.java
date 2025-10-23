import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        int len = 1; // 이동할 거리 (2번 이동하면 거리 1 증가)
        int num = 1;
        int index = 0; // 현재 방향

        int x = N/2;
        int y = N/2;
        arr[x][y] = num;

        StringBuilder sb = new StringBuilder();
        if (num == find) sb.append(x+1).append(" ").append(y+1);

        while(num < N*N) {
            for(int t=0; t<2; t++) { // 같은 길이를 두 번 이동
                for(int i=0; i<len; i++) {
                    if(num == N*N) break;

                    x += dx[index];
                    y += dy[index];
                    arr[x][y] = ++num;

                    if (num == find) sb.append(x+1).append(" ").append(y+1);
                }

                index = (index + 1) % 4; // 방향 전환
            }

            len++; // 이동 거리 증가
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println(sb);

        br.close();
    }
}