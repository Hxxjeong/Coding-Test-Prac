import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int answer = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        move(0);
        System.out.println(answer);

        br.close();
    }

    public static void move(int count) {
        if(count == 5) {
            answer = Math.max(answer, findMax());
            return;
        }

        int[][] backUp = new int[N][N];
        for(int i=0; i<N; i++) backUp[i] = arr[i].clone();

        for(int d=0; d<4; d++) {
            slide(d);   // 이동
            move(count+1);

            // 복원
            for(int i=0; i<N; i++) arr[i] = backUp[i].clone();
        }

    }

    public static int findMax() {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) max = Math.max(max, arr[i][j]);
        }

        return max;
    }

    public static void slide(int dir) {
        switch(dir) {
            case 0:
                for(int col=0; col<N; col++) {
                    int[] temp = new int[N];    // 한 열
                    int idx = 0;    // temp에 넣을 위치
                    int prev = 0;   // 이전 숫자 (합칠 숫자 확인용)

                    // 위쪽에서 아래쪽으로 확인
                    for(int row=0; row<N; row++) {
                        if(arr[row][col] == 0) continue;

                        if(prev == 0) prev = arr[row][col];
                        // 합치는 경우
                        else if(prev == arr[row][col]) {
                            temp[idx++] = prev * 2;
                            prev = 0;
                        }
                        else {
                            temp[idx++] = prev;
                            prev = arr[row][col];
                        }
                    }

                    if(prev != 0) temp[idx] = prev;    // 마지막 남은 값 넣기

                    // 원래 배열에 반영
                    for(int row=0; row<N; row++) arr[row][col] = temp[row];
                }
                break;

            case 1: // Right
                for(int row=0; row<N; row++) {
                    int[] temp = new int[N];    // 한 행
                    int idx = N-1;
                    int prev = 0;

                    // 오른쪽에서 왼쪽으로 확인
                    for(int col = N-1; col >= 0; col--) {
                        if(arr[row][col] == 0) continue;

                        if(prev == 0) prev = arr[row][col];
                        else if(prev == arr[row][col]) {
                            temp[idx--] = prev * 2;
                            prev = 0;
                        }
                        else {
                            temp[idx--] = prev;
                            prev = arr[row][col];
                        }
                    }

                    if(prev != 0) temp[idx] = prev;

                    for(int col=0; col<N; col++) arr[row][col] = temp[col];
                }
                break;

            case 2:
                for(int col=0; col<N; col++) {
                    int[] temp = new int[N];    // 한 열
                    int idx = N-1;
                    int prev = 0;

                    // 아래쪽에서 위쪽으로 확인
                    for(int row=N-1; row>=0; row--) {
                        if(arr[row][col] == 0) continue;

                        if(prev == 0) prev = arr[row][col];
                        else if(prev == arr[row][col]) {
                            temp[idx--] = prev * 2;
                            prev = 0;
                        }
                        else {
                            temp[idx--] = prev;
                            prev = arr[row][col];
                        }
                    }

                    if(prev != 0) temp[idx] = prev;

                    // 원래 배열에 반영
                    for(int row=0; row<N; row++) arr[row][col] = temp[row];
                }
                break;

            case 3:
                for(int row=0; row<N; row++) {
                    int[] temp = new int[N];    // 한 행
                    int idx = 0;
                    int prev = 0;

                    // 왼쪽에서 오른쪽으로 확인
                    for(int col=0; col<N; col++) {
                        if(arr[row][col] == 0) continue;

                        if(prev == 0) prev = arr[row][col];
                        else if(prev == arr[row][col]) {
                            temp[idx++] = prev * 2;
                            prev = 0;
                        }
                        else {
                            temp[idx++] = prev;
                            prev = arr[row][col];
                        }
                    }

                    if(prev != 0) temp[idx] = prev;

                    for(int col=0; col<N; col++) arr[row][col] = temp[col];
                }
                break;
        }
    }
}