import java.io.*;

public class Main {
    static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static String[] move = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String king = input[0];     // 킹의 위치
        String stone = input[1];    // 돌의 위치
        int N = Integer.parseInt(input[2]);

        int kingX = king.charAt(0) - 'A';
        int kingY = king.charAt(1) - '1';
        int stoneX = stone.charAt(0) - 'A';
        int stoneY = stone.charAt(1) - '1';

        for(int i=0; i<N; i++) {
            String moveInput = br.readLine();
            int index = -1;
            for(int j=0; j<8; j++) {
                if (moveInput.equals(move[j])) index = j;    // 움직일 방향 탐색
            }

            int nx = kingX + dy[index];
            int ny = kingY + dx[index];

            // 체스판 범위 내인지 확인
            if(nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                // 킹이 이동할 위치에 돌이 있을 때
                if(nx == stoneX && ny == stoneY) {
                    int stoneNx = stoneX + dy[index];
                    int stoneNy = stoneY + dx[index];

                    // 돌이 이동할 위치가 체스판 범위 내에 있는지 확인
                    if(stoneNx >= 0 && stoneNx < 8 && stoneNy >= 0 && stoneNy < 8) {
                        stoneX = stoneNx;
                        stoneY = stoneNy;
                        kingX = nx;
                        kingY = ny;
                    }
                }
                else {
                    kingX = nx;
                    kingY = ny;
                }
            }
        }

        System.out.println((char) (kingX+'A') + "" + (kingY+1));
        System.out.println((char) (stoneX+'A') + "" + (stoneY+1));

        br.close();
    }
}