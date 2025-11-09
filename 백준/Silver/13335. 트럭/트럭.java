import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int L = Integer.parseInt(input[2]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<w; i++) queue.add(0);

        int answer = 0;
        int totalWeight = 0;
        int i = 0;
        while(!queue.isEmpty()) {
            answer++;
            totalWeight -= queue.poll();    // 다리에서 나가는 트럭

            if(i < n) {
                if(totalWeight + arr[i] <= L) {
                    queue.add(arr[i]);
                    totalWeight += arr[i];
                    i++;
                }
                else queue.add(0); // 트럭 진입 불가
            }
        }

        System.out.println(answer);

        br.close();
    }
}