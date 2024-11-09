import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        String[] inputA = br.readLine().split(" ");
        String[] inputB = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(inputA[i]);
            B[i] = Integer.parseInt(inputB[i]);
        }

        Arrays.sort(A);
        Arrays.sort(B, Comparator.reverseOrder());

        int sum = 0;
        for(int i=0; i<N; i++) sum += (A[i] * B[i]);

        System.out.println(sum);

        br.close();
    }
}