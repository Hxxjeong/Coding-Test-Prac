import java.io.*;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        visited = new boolean[N];
        select(arr, 0, 0);  // 첫번째 사람부터 팀 구성
        System.out.println(min);

        br.close();
    }

    public static void select(int[][] arr, int depth, int start) {
        // 팀 구성 완료
        if(depth >= 1) {    // 최소 한 명 이상
            diff(arr);
        }

        // 절반으로 나뉘는 경우
        if(depth == N/2) return;

        for(int i=start; i<N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            select(arr, depth+1, i+1);
            visited[i] = false;
        }
    }

    public static void diff(int[][] arr) {
        int team1 = 0, team2 = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (visited[i] && visited[j]) { // 선택된 사람들 팀
                    team1 += arr[i][j];
                }
                else if (!visited[i] && !visited[j]) {  // 선택되지 않은 사람들 팀
                    team2 += arr[i][j];
                }
            }
        }

        int diff = Math.abs(team1 - team2);
        min = Math.min(min, diff);
    }
}