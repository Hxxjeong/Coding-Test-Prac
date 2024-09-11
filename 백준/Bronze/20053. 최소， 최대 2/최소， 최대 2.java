import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            String[] s = br.readLine().split(" ");

            for(int j=0; j<N; j++) {
                arr[j] = Integer.parseInt(s[j]);
            }
            Arrays.sort(arr);
            System.out.println(arr[0] + " " + arr[N-1]);
        }

        br.close();
    }
}