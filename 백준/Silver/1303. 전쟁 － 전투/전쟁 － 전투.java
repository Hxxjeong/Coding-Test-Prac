import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new char[M][N];
        for(int i=0; i<M; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) arr[i][j] = line.charAt(j);
        }

        visited = new boolean[M][N];
        int B = 0;
        int W = 0;

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if (visited[i][j]) continue;

                int answer = count(i, j, arr[i][j]);
                if(arr[i][j] == 'B') B += answer * answer;
                else W += answer * answer;
            }
        }

        System.out.println(W + " " + B);
        
        br.close();
    }

    static int count(int i, int j, char soldier) {
        visited[i][j] = true;
        int cnt = 1;

        for(int k=0; k<4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny] || arr[nx][ny] != soldier) continue;

            cnt += count(nx, ny, soldier);
        }

        return cnt;
    }
}
