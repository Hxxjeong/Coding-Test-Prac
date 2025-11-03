import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(B);
            
            int answer = 0;
            for(int i=0; i<N; i++) {
                int left = 0;
                int right = M;
                while(left < right) {
                    int mid = (left + right) / 2;

                    if(A[i] > B[mid]) left = mid + 1;
                    else right = mid;
                }
                answer += left;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
