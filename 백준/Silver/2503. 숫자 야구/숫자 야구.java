import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();   // 질문 받은 숫자 정보

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            int strike = Integer.parseInt(input[1]);
            int ball = Integer.parseInt(input[2]);
            list.add(new int[]{num, strike, ball});
        }

        int answer = 0;
        for(int i=123; i<=987; i++) {   // 가능한 숫자: 123 ~ 987
            int[] nums = new int[3];    // 각 자릿수 숫자
            nums[0] = i / 100;
            nums[1] = (i / 10) % 10;
            nums[2] = i % 10;

            // 0이 포함되거나 같은 숫자가 있는 경우
            if (nums[0] == 0 || nums[1] == 0 || nums[2] == 0) continue;
            if (nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]) continue;

            boolean possible = true;
            for(int[] q: list) {
                int[] guess = {q[0] / 100, (q[0] / 10) % 10, q[0] % 10};
                int strike = 0, ball = 0;

                // 스트라이크와 볼 개수 확인
                for(int j=0; j<3; j++) {
                    if(nums[j] == guess[j]) strike++;
                    else if (nums[j] == guess[(j+1)%3] || nums[j] == guess[(j+2)%3]) ball++;
                }

                if(strike != q[1] || ball != q[2]) {
                    possible = false;
                    break;
                }
            }

            if (possible) answer++;
        }

        System.out.println(answer);

        br.close();
    }
}