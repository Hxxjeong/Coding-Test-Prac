import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[100][100];
        for(int t=0; t<T; t++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            for(int i=x; i<x+10; i++) {
                for(int j=y; j<y+10; j++) arr[i][j] = 1;
            }
        }

        int answer = 0;
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) if(arr[i][j] == 1) answer++;
        }

        System.out.println(answer);

        br.close();
    }
}
