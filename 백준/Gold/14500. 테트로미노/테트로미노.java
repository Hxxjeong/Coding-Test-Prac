import java.io.*;
import java.util.*;

public class Main {
    // 테트로미노의 dy, dx 좌표 변화 (N, M)
    static int[][] dy = {
            {0, 0, 0, 0}, {0, 1, 2, 3},  // ㅡ, ㅣ 모양
            {0, 0, 1, 1},                // ㅁ 모양
            {0, 1, 2, 2}, {0, 0, 1, 2}, {0, 1, 2, 2}, {0, 0, 1, 2}, // L 모양 회전 및 대칭
            {0, 0, 0, 1}, {0, 1, 1, 1}, {0, 1, 1, 1}, {0, 0, 0, 1},
            {0, 1, 1, 2}, {0, 1, 1, 2}, {0, 0, 1, 1}, {0, 0, 1, 1}, // Z 모양 회전 및 대칭
            {0, 1, 1, 2}, {0, 1, 1, 2}, {0, 0, 0, 1}, {0, 1, 1, 1}  // ㅗ 모양 회전
    };

    static int[][] dx = {
            {0, 1, 2, 3}, {0, 0, 0, 0},  // ㅡ, ㅣ 모양
            {0, 1, 0, 1},                // ㅁ 모양
            {0, 0, 0, 1}, {0, 1, 0, 0}, {1, 1, 0, 1}, {0, 1, 1, 1}, // L 모양 회전 및 대칭
            {0, 1, 2, 0}, {0, 0, 1, 2}, {2, 0, 1, 2}, {0, 1, 2, 2},
            {0, 0, 1, 1}, {1, 0, 1, 0}, {0, 1, 1, 2}, {1, 2, 0, 1}, // Z 모양 회전 및 대칭
            {0, 0, 1, 0}, {1, 0, 1, 1}, {0, 1, 2, 1}, {1, 0, 1, 2}  // ㅗ 모양 회전
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);     // 가로
        int M = Integer.parseInt(input[1]);     // 세로

        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++) {
            String[] data = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(data[j]);
            }
        }

        // 배열을 순회하면서 블록 배치
        int max = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                max = Math.max(max, checkBlock(arr, i, j, N, M));  // 각 좌표에서 블록 모양 체크
            }
        }

        System.out.println(max);

        br.close();
    }

    public static int checkBlock(int[][] arr, int y, int x, int N, int M) {
        int max = 0;
        List<Integer> list = new ArrayList<>();

        // 모든 테트로미노 모양에 대해 반복
        for (int i=0; i<19; i++) {
            int sum = 0;
            boolean valid = true;

            // 테트로미노의 각 블록 좌표를 계산
            for (int j=0; j<4; j++) {
                int ny = y + dy[i][j];
                int nx = x + dx[i][j];

                // 범위를 벗어나는 경우 해당 테트로미노 무시
                if (ny >= N || nx >= M) {
                    valid = false;
                    break;
                }

                sum += arr[ny][nx];
            }

            if (valid) list.add(sum);
        }

        // 현재 좌표에서 가능한 테트로미노 중 최대값 찾기
        max = list.stream().max(Integer::compare).orElse(0);

        return max;
    }
}