import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) arr[i][j] = line.charAt(j) - '0';
        }

        int max = 1;
        // 네 꼭짓점 확인 (i, j), (i, j+l), (i+l, j), (i+l, j+l)
        for(int l=1; l<Math.min(N, M); l++) { // l = 한 변의 길이-1
            for(int i=0; i+l<N; i++) {
                for(int j=0; j+l< M; j++) {
                    if(arr[i][j] == arr[i][j+l] && arr[i][j] == arr[i+l][j] && arr[i][j] == arr[i+l][j+l])
                        max = Math.max(max, (l+1) * (l+1));
                }
            }
        }

        System.out.println(max);

        br.close();
    }
}