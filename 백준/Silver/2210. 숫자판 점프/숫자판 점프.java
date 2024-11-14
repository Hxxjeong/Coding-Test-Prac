import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];

        for(int i=0; i<5; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<5; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) dfs(i, j, 0);
        }

        System.out.println(set.size());

        br.close();
    }

    public static void dfs(int i, int j, int depth) {
        if(depth == 6) {
            set.add(sb.toString());
            return;
        }

        sb.append(arr[i][j]);  // 현재 위치의 숫자를 추가

        for(int k=0; k<4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

            dfs(nx, ny, depth+1);
        }

        sb.deleteCharAt(sb.length()-1);  // 마지막에 추가한 문자 제거
    }
}