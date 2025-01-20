import java.io.*;
import java.util.*;

class Node{
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M, P;
    static char[][] map;
    static int[] maxMove;
    static Queue<Node>[] queues;
    static boolean[][] visited;
    public static int[] answerCnt = new int[10];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        P = Integer.parseInt(input[2]);

        map = new char[N][M];
        queues = new Queue[P+1];
        for(int i=0; i<=P; i++) queues[i] = new LinkedList<>();

        input = br.readLine().split(" ");
        maxMove = new int[P+1];
        for(int i=1; i<=P; i++) maxMove[i] = Integer.parseInt(input[i-1]);

        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();

            for(int j=0; j<M; j++) {
                if(map[i][j] >= '1' && map[i][j] <= '9') {
                    visited[i][j] = true;
                    queues[map[i][j]-'0'].add(new Node(i, j));
                    answerCnt[map[i][j]-'0'] += 1;
                }
            }
        }

        bfs();

        for(int i=1; i<=P; i++) System.out.print(answerCnt[i] + " ");
    }

    public static void bfs() {
        boolean flag = false;

        while(!flag) {
            flag = true;

            for(int i=1; i<=P; i++) {
                int moveCnt = maxMove[i];
                int qSize = queues[i].size();
                int cnt = 0;
                int cycleCnt = 0;

                while(!queues[i].isEmpty() && cycleCnt < moveCnt) {
                    Node temp = queues[i].poll();

                    for(int j=0; j<4; j++) {
                        int nr = temp.r + dx[j];
                        int nc = temp.c + dy[j];

                        if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == '#') continue;

                        visited[nr][nc] = true;
                        answerCnt[i] += 1;
                        flag = false;
                        queues[i].offer(new Node(nr, nc));
                    }

                    cnt += 1;

                    if(qSize == cnt) {
                        qSize = queues[i].size();
                        cnt = 0;
                        cycleCnt += 1;
                    }
                }
            }
        }
    }
}