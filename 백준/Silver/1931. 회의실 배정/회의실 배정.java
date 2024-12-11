import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            list.add(new int[]{start, end});
        }

        // 끝나는 시간을 기준으로 정렬 (같은 경우 시작 시간을 기준으로 정렬)
        Collections.sort(list, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int answer = 1;
        int endTime = list.get(0)[1];
        int index = 1;
        while(index < list.size()) {
            // 다음 시작 시간이 이전 끝 시간보다 이후인 경우
            if(list.get(index)[0] >= endTime) {
                endTime = list.get(index)[1];
                answer++;
                index++;
            }

            else index++;
        }

        System.out.println(answer);

        br.close();
    }
}
