import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int B = Integer.parseInt(input[2]);

        int[][] arr = new int[N][M];
        int min = 256, max = 0;

        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }

        int count = Integer.MAX_VALUE;
        int height = 0;
        for(int h=min; h<=max; h++) {   // 기준 높이
            int remove = 0; // 제거한 블록
            int add = 0;    // 추가한 블록

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    int diff = arr[i][j] - h;
                    if(diff > 0) remove += diff;   // 높이가 더 높으면 제거
                    else add -= diff;   // 높이가 더 낮으면 추가
                }
            }

            // 인벤토리에 있는 블록 수 체크
            if(remove + B >= add) {
                int time = remove*2 + add;
                if(time < count) {
                    count = time;
                    height = h;
                }
                else if(time == count) height = Math.max(height, h); // 동일 시간일 경우 더 높은 높이
            }
        }

        System.out.println(count + " " + height);

        br.close();
    }
}
