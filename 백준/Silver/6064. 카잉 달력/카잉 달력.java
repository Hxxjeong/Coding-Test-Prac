import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]) - 1;  // 0-based로 맞추기 위해 -1 (나머지 범위가 0 ~ M-1로 나오기 위함)
            int y = Integer.parseInt(input[3]) - 1;  // 0-based로 맞추기 위해 -1 (나머지 범위가 0 ~ N-1로 나오기 위함)

            // x를 기준으로 N과 비교하면서 나머지가 y가 되는 해 찾기
            int year = -1;
            for (int k=x; k<lcm(M, N); k+=M) {
                if (k % N == y) {
                    year = k + 1;  // 0-based에서 다시 1-based로 변환
                    break;
                }
            }

            System.out.println(year);   // 찾지 못하면 -1
        }

        br.close();
    }

    // 최대공약수
    public static int gcd(int m, int n) {
        if(n == 0) return m;
        return gcd(n, m % n);
    }
    
    // 최소공배수
    public static int lcm(int m, int n) {
        return m * n / gcd(m, n);
    }
}