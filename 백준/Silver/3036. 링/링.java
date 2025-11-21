import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int first = arr[0];
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N; i++) {
            int gcd = gcd(first, arr[i]);
            sb.append(first/gcd).append("/").append(arr[i]/gcd).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}