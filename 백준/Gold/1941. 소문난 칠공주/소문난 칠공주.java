import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int answer;
    static char[][] arr = new char[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++) {
            String input = br.readLine();
            for(int j=0; j<5; j++) arr[i][j] = input.charAt(j);
        }

        func(0, 0, new ArrayList<>());
        System.out.println(answer);

        br.close();
    }

    // 7개 뽑기
    public static void func(int start, int depth, List<int[]> picked) {
        if(depth == 7) {
            if(isConnected(picked)) answer++;   // 연결되었는지 확인
            return;
        }

        for (int i = start; i < 25; i++) {
            int x = i / 5;  // 행
            int y = i % 5;  // 열
            picked.add(new int[]{x, y});
            func(i+1, depth+1, picked);
            picked.remove(picked.size()-1); // 백트래킹
        }
    }

    public static boolean isConnected(List<int[]> picked) {
        int dasom = 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> selectedSet = new HashSet<>();
        boolean[][] visited = new boolean[5][5];

        for(int[] p: picked) selectedSet.add(p[0] + "," + p[1]);

        queue.add(picked.get(0));
        visited[picked.get(0)[0]][picked.get(0)[1]] = true;
        int count = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            count++;

            if(arr[x][y] == 'S') dasom++;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && !visited[nx][ny] && selectedSet.contains(nx + "," + ny)) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return count == 7 && dasom >= 4;
    }
}
