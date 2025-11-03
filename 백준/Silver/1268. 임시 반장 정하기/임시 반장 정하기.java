import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][5];
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<5; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) continue;

                for(int k=0; k<5; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        answer[i]++;
                        break; // 한 번이라도 같은 반을 했으면 break
                    }
                }
            }
        }

        int max = Arrays.stream(answer).max().getAsInt();
        for(int i=0; i<n; i++) {
            if(max == answer[i]) {
                System.out.println(i+1);
                return;
            }
        }

        br.close();
    }
}
