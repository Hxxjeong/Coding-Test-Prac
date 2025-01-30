import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int h, w;
    static char[][] arr;
    static boolean[][] visited;
    static boolean[] keys;
    static List<int[]>[] doors;  // 각 문('A'~'Z')의 위치 저장

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            String[] input = br.readLine().split(" ");
            h = Integer.parseInt(input[0]);
            w = Integer.parseInt(input[1]);

            arr = new char[h][w];
            visited = new boolean[h][w];
            keys = new boolean[26];
            doors = new ArrayList[26];
            for(int i=0; i<26; i++) doors[i] = new ArrayList<>();

            for(int i=0; i<h; i++) {
                String line = br.readLine();
                for(int j=0; j<w; j++) arr[i][j] = line.charAt(j);
            }

            String key = br.readLine();
            if(!key.equals("0")) {
                for(char c: key.toCharArray()) keys[c-'a'] = true;
            }

            sb.append(bfs()).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int file = 0;

        // 바깥쪽 경계 탐색
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                // 테두리 부분 탐색 -> 파일 발견 시 count 증가
                if((i == 0 || i == h-1 || j == 0 || j == w-1) && findFile(i, j, queue)) file++;
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= h || ny >= w || visited[nx][ny] || arr[nx][ny] == '*') continue;

                if(findFile(nx, ny, queue)) file++;
            }
        }

        return file;
    }

    public static boolean findFile(int x, int y, Queue<int[]> queue) {
        char cell = arr[x][y];

        if(visited[x][y] || cell == '*') return false;

        visited[x][y] = true;

        // 문서
        if(cell == '$') {
            queue.add(new int[]{x, y});
            return true;
        }
        // 문
        else if(cell >= 'A' && cell <= 'Z') {
            int doorIndex = cell - 'A';
            if(keys[doorIndex]) queue.add(new int[]{x, y});    // 이미 열쇠 있는 경우
            else doors[doorIndex].add(new int[]{x, y});     // 열쇠가 없으면 위치 저장
        }
        // 열쇠
        else if(cell >= 'a' && cell <= 'z') {
            int index = cell - 'a';
            keys[index] = true;
            queue.add(new int[]{x, y});

            // 해당 키로 열 수 있는 문 다시 방문
            queue.addAll(doors[index]);

            doors[index].clear();   // 다시 방문하기 위해 비우기
        }
        // 빈 공간
        else queue.add(new int[]{x, y});

        return false;
    }
}
