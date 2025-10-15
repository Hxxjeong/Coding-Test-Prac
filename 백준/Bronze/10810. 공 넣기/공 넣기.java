import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input  = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        for(int m=0; m<M; m++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0])-1;
            int end = Integer.parseInt(input[1])-1;
            int k = Integer.parseInt(input[2]);
            for(int i=start; i<=end; i++) {
                arr[i] = k;
            }
        }

        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));

        br.close();
    }
}