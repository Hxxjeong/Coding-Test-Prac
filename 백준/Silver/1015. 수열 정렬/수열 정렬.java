import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) list.add(arr[i]);

        Collections.sort(list);

        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            int index = list.indexOf(arr[i]);
            list.set(index, -1);
            answer[i] = index;
        }

        for(int i=0; i<N; i++) System.out.print(answer[i] + " ");

        br.close();
    }
}