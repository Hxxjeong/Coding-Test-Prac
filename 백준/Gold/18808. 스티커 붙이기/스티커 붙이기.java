import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[][] arr = new int[N][M];
        for(int k=0; k<K; k++) {
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);

            int[][] sticker = new int[r][c];
            for(int i=0; i<r; i++) {
                input = br.readLine().split(" ");
                for(int j=0; j<c; j++) sticker[i][j] = Integer.parseInt(input[j]);
            }

            l: for(int rot=0; rot<4; rot++) {   // 회전
                // 스티커 붙일 위치
                for(int x=0; x<=N-sticker.length; x++) {
                    for(int y=0; y<=M-sticker[0].length; y++) {
                        if(canAttach(sticker, arr, x, y)) {
                            attach(sticker, arr, x, y);
                            break l;
                        }
                    }
                }
                sticker = rotate(sticker); // 회전
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) if(arr[i][j] == 1) answer++;
        }

        System.out.println(answer);

        br.close();
    }

    static boolean canAttach(int[][] sticker, int[][] arr, int x, int y) {
        int r = sticker.length;
        int c = sticker[0].length;

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(sticker[i][j] == 1) {
                    if(x+i >= arr.length || y+j >= arr[0].length) return false;

                    if(arr[x+i][y+j] == 1) return false;
                }
            }
        }

        return true;
    }


    static void attach(int[][] sticker, int[][] arr, int x, int y) {
        int r = sticker.length;
        int c = sticker[0].length;

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(sticker[i][j] == 1) arr[x+i][y+j] = 1;
            }
        }
    }

    static int[][] rotate(int[][] s) {
        int r = s.length;
        int c = s[0].length;
        int[][] rotated = new int[c][r];

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) rotated[j][r-1-i] = s[i][j];
        }

        return rotated;
    }
}