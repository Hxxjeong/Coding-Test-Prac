import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int max = arr[N-1];
            long answer = 0;
            for(int j=N-1; j>=0; j--) {
                if(arr[j] > max) max = arr[j];
                else answer += max - arr[j];
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
