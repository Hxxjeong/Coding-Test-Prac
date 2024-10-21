import java.io.*;

public class Main {
    static boolean[] broken = new boolean[10];  // 고장난 버튼

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 목표 채널
        int M = Integer.parseInt(br.readLine());    // 고장난 버튼의 수

        // 고장난 버튼 입력
        if (M > 0) {
            String[] input = br.readLine().split(" ");
            for (int i=0; i<M; i++) broken[Integer.parseInt(input[i])] = true;
        }

        // 초기 채널 100번
        if(N == 100) {
            System.out.println(0);
            return;
        }

        int minPress = Math.abs(N-100);   // +, - 버튼으로만 이동하는 경우

        // 숫자 버튼을 사용하여 채널을 이동하는 경우 (0부터 증가하여 최솟값 찾기)
        for (int i=0; i<=999999; i++) {
            if (canPress(i)) { // 숫자를 만들 수 있는 경우
                int pressCount = String.valueOf(i).length() + Math.abs(N-i); // 숫자 버튼 누르는 횟수 + 채널 차이
                minPress = Math.min(minPress, pressCount); // 최소 버튼 클릭 수 갱신
            }
        }

        System.out.println(minPress);

        br.close();
    }

    // 채널을 숫자 버튼으로 누를 수 있는지 확인
    public static boolean canPress(int n) {
        if (n == 0) return !broken[0];

        while (n > 0) {
            if (broken[n%10]) return false; // 고장난 버튼 포함 시 false
            n /= 10;
        }

        return true;
    }
}