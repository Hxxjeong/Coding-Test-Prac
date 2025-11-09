import java.io.*;
import java.util.*;

public class Main {
    // 상우하좌
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int[][] one = {{0}, {1}, {2}, {3}};    // 4가지
    static int[][] two = {{1, 3}, {0, 2}};  // 2가지
    static int[][] three = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};    // 4가지
    static int[][] four = {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {0, 2, 3}};     // 4가지
    static int[][] five = {{0, 1, 2, 3}};     // 1가지

    static int N, M;
    static int[][] arr;
    static List<int[]> list = new ArrayList<>();    // CCTV 위치 (x, y, value)
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                int value = Integer.parseInt(input[j]);
                if(value >= 1 && value <= 5) list.add(new int[]{i, j, value});
                arr[i][j] = value;
            }
        }

        dfs(0);
        System.out.println(answer);

        br.close();
    }

    static void dfs(int depth) {
        if(depth == list.size()) {
            answer = Math.min(answer, countBlind(arr));
            return;
        }

        int[] cur = list.get(depth);
        int x = cur[0];
        int y = cur[1];
        int type = cur[2];

        int[][] cctv = getCCTV(type);    // CCTV 종류 확인
        for(int[] dir: cctv) {
            List<int[]> change = new ArrayList<>();    // 복원을 위한 리스트

            for(int i: dir) watch(arr, x, y, i, change);
            dfs(depth+1);
            for(int[] ch: change) arr[ch[0]][ch[1]] = 0;    // 복원
        }
    }

    static int[][] getCCTV(int type) {
        switch(type) {
            case 1: return one;
            case 2: return two;
            case 3: return three;
            case 4: return four;
            case 5: return five;
        }
        return null;
    }

    static void watch(int[][] arr, int x, int y, int dirIdx, List<int[]> change) {
        int nx = x + dir[dirIdx][0];
        int ny = y + dir[dirIdx][1];

        while(nx >= 0 && ny >= 0 && nx < N && ny < M) {
            if(arr[nx][ny] == 6) break;
            if(arr[nx][ny] == 0) {
                arr[nx][ny] = -1; // 감시
                change.add(new int[]{nx, ny});  // 변화
            }

            nx += dir[dirIdx][0];
            ny += dir[dirIdx][1];
        }
    }

    static int countBlind(int[][] arr) {
        int count = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0) count++;
            }
        }
        return count;
    }
}