import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(fac(N));

        br.close();
    }

    public static int fac(int N) {
        int[] arr = new int[N+1];
        arr[0] = 1;

        for(int i=1; i<=N; i++) {
            arr[i] = arr[i-1] * i;
        }

        return arr[N];
    }
}