import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        func(0, 0, N);
        Arrays.stream(answer).forEach(System.out::println);

        br.close();
    }

    public static void func(int x, int y, int size) {
        // 종이가 모두 같은 색일 때 answer에 저장
        if(isSame(x, y, size)) {
            answer[arr[x][y]]++;
            return;
        }

        // 다르면 자르기
        int newSize = size / 2;
        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) func(x + i*newSize, y + j*newSize, newSize);
        }
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
