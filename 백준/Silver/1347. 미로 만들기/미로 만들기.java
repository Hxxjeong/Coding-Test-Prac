import java.io.*;

public class Main {
    // 상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int move = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        int[][] arr = new int[101][101];
        int startX = 50;
        int startY = 50;
        arr[startX][startY] = 1;

        int index = 2;  // 초기 남쪽 방향
        for(int i=0; i<move; i++) {
            if(input[i] == 'L')
                index = (index+3) % 4;    // 왼쪽으로 회전
            else if(input[i] == 'R')
                index = (index+1) % 4;    // 오른쪽으로 회전
            // 현재 방향으로 전진
            else {
                int nx = dx[index] + startX;
                int ny = dy[index] + startY;
                arr[nx][ny] = 1;

                startX = nx;
                startY = ny;
            }
        }

        int minX = 101, maxX = 0, minY = 101, maxY = 0;
        for(int i=0; i<101; i++) {
            for(int j=0; j<101; j++) {
                if(arr[i][j] == 1) {
                    if(i < minX) minX = i;
                    if(i > maxX) maxX = i;
                    if(j < minY) minY = j;
                    if(j > maxY) maxY = j;
                }
            }
        }

        // 출력
        for(int i=minX; i<=maxX; i++) {
            for(int j=minY; j<=maxY; j++) {
                if(arr[i][j] == 1) System.out.print(".");
                else System.out.print("#");
            }
            System.out.println();
        }

        br.close();
    }
}