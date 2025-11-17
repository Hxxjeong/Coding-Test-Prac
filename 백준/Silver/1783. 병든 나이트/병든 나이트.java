import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        if(N == 1) System.out.println(1);   // 위로 올라가기 불가
        else if(N == 2) {   // M에 따라서 가능 횟수 달라짐 (문제의 2번과 3번 방향 가능)
            // M이 1이면 이동 불가
            int move = (M-1) / 2;   // 2 이상일 떄 (M/2) 몫만큼 이동 가능
            System.out.println(Math.min(4, move+1));    // 방문 칸 = 이동 횟수+1
        }
        else {  // 4가지 방향을 모두 가려면 M이 7 이상이어야 함 (1+2+2+1 = 6)
            if(M < 7) System.out.println(Math.min(4, M));
            // 4번 이동 이후에는 오른쪽 위로 계속 이동 가능 → M-2 칸 방문
            else System.out.println(M-2);
        }

        br.close();
    }
}