import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] arr = new char[N][N];
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<N; j++) arr[i][j] = input.charAt(j);
        }

        int width = 0;
        for(int i=0; i<N; i++) {
            int count = 0;
            for(int j=0; j<N; j++) {
                if (arr[i][j] == '.') count++;
                if(arr[i][j] == 'X' || j == N-1) { // 벽을 만나거나 줄의 끝
                    if(count >= 2) width++;
                    count = 0;
                }
            }
        }

        int height = 0;
        for(int j=0; j<N; j++) {
            int count = 0;
            for(int i=0; i<N; i++) {
                if (arr[i][j] == '.') count++;
                if (arr[i][j] == 'X' || i == N-1) {
                    if (count >= 2) height++;
                    count = 0;
                }
            }
        }

        System.out.println(width + " " + height);

        br.close();
    }
}