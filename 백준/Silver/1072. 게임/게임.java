import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long X = Long.parseLong(input[0]);
        long Y = Long.parseLong(input[1]);

        long Z = Y * 100 / X;
        if(Z >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1_000_000_000;
        long answer = -1;
        while(left <= right) {
            long mid = (left + right) / 2;
            long newZ = ((Y + mid) * 100) / (X + mid);

            if (newZ > Z) {
                answer = mid;
                right = mid-1;  // 더 작게 시도
            }
            else left = mid+1;   // 더 많이 이겨야 함
        }

        System.out.println(answer);

        br.close();
    }
}