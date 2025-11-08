import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N];
        for(int i=0; i<N; i++) arr[i] = Double.parseDouble(br.readLine());

        double[] muls = new double[N];
        muls[0] = arr[0];
        double answer = muls[0];
        for(int i=1; i<N; i++) {
            muls[i] = Math.max(arr[i], muls[i-1] * arr[i]); // 0.0 고려
            answer = Math.max(answer, muls[i]);
        }

        System.out.println(String.format("%.3f", answer));

        br.close();
    }
}