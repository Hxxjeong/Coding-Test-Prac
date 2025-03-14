import java.io.*;

public class Main {
    // 10시 방향부터 시계 방향 순 (10, 11, 1, 2, 4, 5, 7, 8)
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};   // 문제에서 위로 갈수록 숫자가 늘어남
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] visited = new boolean[6][6];
        String firstInput = br.readLine();  // 첫 번째 위치
        int startX = firstInput.charAt(0) - 'A';
        int startY = firstInput.charAt(1) - '1';
        int prevX = startX, prevY = startY;

        visited[prevX][prevY] = true;

        for(int i=1; i<36; i++) {
            String input = br.readLine();
            int x = input.charAt(0) - 'A';
            int y = input.charAt(1) - '1';

            boolean validMove = false;
            for (int j=0; j<8; j++) {
                int nx = prevX + dx[j];
                int ny = prevY + dy[j];

                // 이동 규칙에 해당하는 경우
                if (nx == x && ny == y) {
                    validMove = true;
                    break;
                }
            }

            // 이동 규칙에 맞지 않거나 이미 방문한 곳인 경우
            if (!validMove || visited[x][y]) {
                System.out.println("Invalid");
                return;
            }

            visited[x][y] = true;
            prevX = x;
            prevY = y;
        }

        // 마지막 위치에서 시작 위치로 돌아갈 수 있는지 확인
        boolean toStart = false;
        for (int i=0; i<8; i++) {
            int nx = prevX + dx[i];
            int ny = prevY + dy[i];

            if (nx == startX && ny == startY) {
                toStart = true;
                break;
            }
        }

        System.out.println(toStart ? "Valid" : "Invalid");

        br.close();
    }
}
