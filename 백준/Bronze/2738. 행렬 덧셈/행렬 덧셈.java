import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++) arr[i][j] += Integer.parseInt(input[j]);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) System.out.print(arr[i][j] + " ");
            System.out.println();
        }

        br.close();
    }
}