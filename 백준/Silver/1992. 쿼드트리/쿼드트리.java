import java.io.*;

public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) arr[i][j] = line.charAt(j) - '0';
        }

        func(0, 0, N);
        System.out.println(sb);

        br.close();
    }

    public static void func(int x, int y, int size) {
        if(isSame(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }

        sb.append("("); // 4등분 시작

        int newSize = size / 2;
        func(x, y, newSize);                      // 왼쪽 위
        func(x, y+newSize, newSize);            // 오른쪽 위
        func(x+newSize, y, newSize);            // 왼쪽 아래
        func(x+newSize, y+newSize, newSize);  // 오른쪽 아래

        sb.append(")"); // 4등분 끝
    }

    public static boolean isSame(int x, int y, int size) {
        int num = arr[x][y];    // 기존값

        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(arr[i][j] != num) return false;
            }
        }

        return true;
    }
}
