import java.io.*;

public class Main {
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][2*N-1]; // 삼각형 형태로 배열 크기 설정
        for(int i=0; i<N; i++) {
            for(int j=0; j<2*N-1; j++) arr[i][j] = ' ';
        }

        func(0, 0, N);
        for(int i=0; i<N; i++) sb.append(arr[i]).append("\n");
        System.out.print(sb);

        br.close();
    }

    public static void func(int x, int y, int size) {
        if(size == 3) {  // 기본 크기 3x3 삼각형
            arr[x][y+2] = '*';  // 제일 윗 줄
            arr[x+1][y+1] = '*';    // 가운데 줄
            arr[x+1][y+3] = '*';    // 가운데 줄
            for(int i=0; i<5; i++) arr[x+2][y+i] = '*'; // 제일 아랫줄
            return;
        }

        int newSize = size / 2;
        func(x, y+newSize, newSize);
        func(x+newSize, y, newSize);
        func(x+newSize, y+2*newSize, newSize);
    }
}
