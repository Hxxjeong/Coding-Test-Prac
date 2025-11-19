import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int R, C;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        int N = Integer.parseInt(input[2]);

        arr = new char[R][C];
        for(int i=0; i<R; i++) {
            String line = br.readLine();
            for(int j=0; j<C; j++) arr[i][j] = line.charAt(j);
        }

        // 변화 없음
        if(N == 1) {
            print(arr);
            return;
        }

        // 모두 폭탄 설치
        if(N % 2 == 0) {
            char[][] full = fullBomb();
            print(full);
            return;
        }

        // N이 홀수인 경우: 3초 패턴 or 5초 패턴
        char[][] three = explode(copy(arr));       // 3초 후
        char[][] five = explode(copy(three));    // 5초 후

        if(N % 4 == 3) print(three);   // 3초 패턴
        else print(five);             // 5초 패턴

        br.close();
    }

    static char[][] explode(char[][] arr) {
        boolean[][] bomb = new boolean[R][C];

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j] == 'O') bomb[i][j] = true;
            }
        }

        // 전체를 폭탄으로 채운 상태에서 초기 폭탄 터트리기
        char[][] result = fullBomb();
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(bomb[i][j]) {
                    result[i][j] = '.';

                    for(int d=0; d<4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

                        result[nx][ny] = '.';
                    }
                }
            }
        }

        return result;
    }

    static char[][] fullBomb() {
        char[][] result = new char[R][C];
        for(int i=0; i<R; i++) Arrays.fill(result[i], 'O');

        return result;
    }

    static char[][] copy(char[][] a) {
        char[][] res = new char[R][C];
        for(int i=0; i<R; i++) res[i] = a[i].clone();

        return res;
    }

    static void print(char[][] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++) sb.append(arr[i]).append("\n");
        System.out.print(sb);
    }
}