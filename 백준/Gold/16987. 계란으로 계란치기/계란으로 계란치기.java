import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> list = new ArrayList<>();
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});    // 내구도, 무게
        }

        func(0);
        System.out.println(answer);

        br.close();
    }

    private static void func(int depth) {
        // 계란을 다 들었을 때 깨진 계란 계산
        if(depth == N) {
            int count = 0;
            for (int[] cur: list) if(cur[0] <= 0) count++;
            answer = Math.max(answer, count);
            return;
        }

        // 계란이 깨지면 다음 계란으로 이동
        if(list.get(depth)[0] <= 0) {
            func(depth+1);
            return;
        }

        boolean flag = false; // 한 번이라도 계란을 쳤는지 여부
        for(int i=0; i<N; i++) {
            if(i == depth || list.get(i)[0] <= 0) continue; // 자기 자신이거나 깨진 계란인 경우 건너뛰기

            list.get(depth)[0] -= list.get(i)[1];
            list.get(i)[0] -= list.get(depth)[1];

            func(depth+1);
            flag = true;

            // 백트래킹
            list.get(depth)[0] += list.get(i)[1];
            list.get(i)[0] += list.get(depth)[1];
        }

        // 한 번도 계란을 치지 못한 경우 (남은 계란이 모두 깨진 경우)
        if(!flag) func(depth+1);
    }
}
