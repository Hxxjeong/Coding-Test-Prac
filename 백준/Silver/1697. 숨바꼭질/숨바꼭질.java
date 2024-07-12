import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 수빈이의 위치
        int K = Integer.parseInt(input[1]); // 동생의 위치

        int[] distance = new int[200001];
        Arrays.fill(distance, -1); // 거리 초기화

        distance[N] = 0;    // 수빈이의 위치 초기화

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i: new int[]{cur-1, cur+1, cur*2}) {
                if(i < 0 || i >= 200001) continue;    // 조건의 범위에서 벗어난 경우
                if(distance[i] != -1) continue; // 이미 방문한 위치일 경우

                distance[i] = distance[cur] + 1;    // 새로운 위치일 때 거리 갱신
                queue.offer(i);

                // 동생의 위치에 도달하면 종료
                if(i == K) {
                    System.out.println(distance[K]);
                    return;
                }
            }
        }

        System.out.println(0);  // 둘의 위치가 같을 때

        br.close();
    }
}