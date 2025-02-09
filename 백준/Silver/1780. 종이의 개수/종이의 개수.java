import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] answer = new int[3];

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
        // 종이가 모두 같은 숫자일 때 -1, 0, 1에 따라 answer[0], answer[1], answer[2]에 저장
        if(isSame(x, y, size)) {
            answer[arr[x][y] + 1]++;
            return;
        }

        // 다르면 9개로 자르기
        int newSize = size / 3; // 3등분
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) func(x + i*newSize, y + j*newSize, newSize);
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
