import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] arr = new int[N+1];
        arr[0] = 1;
        for(int i=1; i<=N; i++) arr[i] = arr[i-1]*i;

        // nCk = n!/k!(n-k)!
        System.out.println(arr[N]/(arr[K]*arr[N-K]));

        br.close();
    }
}