import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int right=0; right<N; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // 종류가 3개 이상이면 left 줄이기
            while(map.size() > 2) {
                map.put(arr[left], map.get(arr[left])-1);
                if(map.get(arr[left]) == 0) map.remove(arr[left]);
                left++;
            }

            answer = Math.max(answer, right-left+1);
        }

        System.out.println(answer);

        br.close();
    }
}