import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int N, M, G, R;
    static int answer = Integer.MIN_VALUE;
    static int[][] arr;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        G = Integer.parseInt(input[2]);
        R = Integer.parseInt(input[3]);

        arr = new int[N][M];
        list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                if(arr[i][j] == 2) list.add(new int[]{i, j});
            }
        }

        combination(0, 0, new ArrayList<>());
        System.out.println(answer);

        br.close();
    }

    // 배양액을 심을 수 있는 곳에서 G개, R개 고르기
    public static void combination(int index, int select, List<int[]> selectedList) {
        if(select == G+R) {
            make(0, 0, new ArrayList<>(), selectedList);
            return;
        }

        if(index >= list.size()) return;

        // 심을 수 있는 곳을 선택하는 경우
        selectedList.add(list.get(index));
        combination(index+1, select+1, selectedList);
        selectedList.remove(selectedList.size() - 1);   // 백트래킹

        // 심을 수 있는 곳을 선택하지 않는 경우
        combination(index+1, select, selectedList);
    }

    // 선택한 좌표에서 G개를 초록으로 진행
    public static void make(int index, int gSelect, List<int[]> gList, List<int[]> selectedList) {
        if(gSelect == G) {
            List<int[]> rList = new ArrayList<>(selectedList);
            rList.removeAll(gList);

            // greenList, redList로 BFS 실행
            bfs(gList, rList);
            return;
        }

        if(index >= selectedList.size()) return;

        gList.add(selectedList.get(index));
        make(index+1, gSelect+1, gList, selectedList);
        gList.remove(gList.size()-1);   // 백트래킹

        make(index+1, gSelect, gList, selectedList);
    }

    public static void bfs(List<int[]> gList, List<int[]> rList) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] colors = new int[N][M];     // 1: 초록, 2: 빨강, 3: 꽃
        int[][] times = new int[N][M];
        int count = 0;

        // 초기 초록 배양액
        for(int[] cur: gList) {
            int x = cur[0];
            int y = cur[1];

            queue.add(new int[]{x, y, 0, 1});
            colors[x][y] = 1;
            times[x][y] = 0;
        }

        // 초기 빨강 배양액
        for(int[] cur: rList) {
            int x = cur[0];
            int y = cur[1];

            queue.add(new int[]{x, y, 0, 2});
            colors[x][y] = 2;
            times[x][y] = 0;
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];
            int color = cur[3];

            if(colors[x][y] == 3) continue;     // 꽃인 경우

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0 || colors[nx][ny] == 3) continue;

                // 아직 방문하지 않은 경우
                if(colors[nx][ny] == 0) {
                    colors[nx][ny] = color;
                    times[nx][ny] = time+1;
                    queue.add(new int[]{nx, ny, time+1, color});
                }
                // 반대 색 배양액이 같은 시간에 도달한 경우 꽃으로 변함
                else if(colors[nx][ny] != color && times[nx][ny] == time+1) {
                    colors[nx][ny] = 3;
                    count++;
                }
            }
        }

        answer = Math.max(answer, count);
    }
}