import java.io.*;

public class Main {
    static int[] arr = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 1부터 7까지
        // 1 2 4 7 13 24 41
        // (i-3) + (i-2) + (i-1) = i (i is index)
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i=4; i<arr.length; i++)
            arr[i] = arr[i-3] + arr[i-2] + arr[i-1];

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[n]);
        }

        br.close();
    }
}