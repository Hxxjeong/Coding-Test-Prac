import java.io.*;

public class Main {
    static long[] arr = new long[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1부터 6까지
        // 1 3(2+1) 5(3+2) 11(5+6) 21(8+13) 43(13+30)
        // (i-2) * 2 + (i-1) = i (i is index)
        arr[1] = 1;
        arr[2] = 3;

        for(int i=3; i<arr.length; i++)
            arr[i] = (arr[i-1] + arr[i-2] * 2) % 10007;

        System.out.println(arr[n]);

        br.close();
    }
}