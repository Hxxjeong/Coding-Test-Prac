import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited = new boolean[2001][2001];   // 화면 이모티콘, 클립보드 이모티콘

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0, 0});
        visited[1][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int clipboard = cur[1];
            int time = cur[2];

            if(x == S) {
                System.out.println(time);
                return;
            }

            // 클립보드에 복사
            if(!visited[x][x]) {
                visited[x][x] = true;
                queue.add(new int[]{x, x, time+1});
            }

            // 클립보드 붙여넣기
            if(clipboard > 0 && x+clipboard <= 2000 && !visited[x+clipboard][clipboard]) {
                visited[x+clipboard][clipboard] = true;
                queue.add(new int[]{x+clipboard, clipboard, time+1});
            }

            // 화면 이모티콘 삭제
            if(x > 0 && !visited[x-1][clipboard]) {
                visited[x-1][clipboard] = true;
                queue.add(new int[]{x-1, clipboard, time + 1});
            }
        }

        br.close();
    }
}
