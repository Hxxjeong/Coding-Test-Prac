import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        System.out.println(func(N, r, c));

        br.close();
    }

    public static int func(int n, int r, int c) {
        if(n == 0) return 0;    // (0, 0) = 0

        int half = 1 << (n-1);

        if(r < half && c < half) return func(n-1, r, c);    // 0번 사각형
        if(r < half && c >= half) return half*half + func(n-1, r, c-half);  // 1번 사각형
        if(r >= half && c < half) return 2*half*half + func(n-1, r-half, c);    // 2번 사각형
        return 3*half*half + func(n-1, r-half, c-half);     // 3번 사각형
    }
}
