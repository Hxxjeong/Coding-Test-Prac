import java.io.*;

public class Main {
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) arr[i][j] = ' ';
        }

        func(0, 0, N);
        for(int i=0; i<N; i++) sb.append(arr[i]).append("\n");
        System.out.print(sb);

        br.close();
    }

    public static void func(int x, int y, int size) {
        if(size == 1) {
            arr[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(i == 1 && j == 1) continue; // 가운데 공백
                func(x+i*newSize, y+j*newSize, newSize);
            }
        }
    }
}
