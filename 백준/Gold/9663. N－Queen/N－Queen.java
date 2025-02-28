import java.io.*;

public class Main {
    static int N;
    static int count = 0;
    static boolean[] visited;   // 열 확인
    static boolean[] visited2;   // 좌상향 대각선 확인 (x+y 동일)
    static boolean[] visited3;   // 우하향 대각선 확인 (x-y 동일)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);

        visited = new boolean[N];
        visited2 = new boolean[2*N-1];
        visited3 = new boolean[2*N-1];
        func(0);
        System.out.println(count);

        br.close();
    }

    public static void func(int depth) {
        if(depth == N) {
            count++;
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i] && !visited2[i+depth] && !visited3[depth-i+N-1]) {
                visited[i] = true;
                visited2[i+depth] = true;
                visited3[depth-i+N-1] = true;
                func(depth+1);
                visited[i] = false;
                visited2[i+depth] = false;
                visited3[depth-i+N-1] = false;
            }
        }
    }
}
