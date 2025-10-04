import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        int g = arr[1] - arr[0];
        for(int i=2; i<N; i++) g = gcd(g, arr[i] - arr[i-1]);

        int answer = 0;
        for(int i=1; i<N; i++) {
            answer += (arr[i] - arr[i-1]) / g - 1;  // 끝점 제외
        }

        System.out.println(answer);

        br.close();
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
