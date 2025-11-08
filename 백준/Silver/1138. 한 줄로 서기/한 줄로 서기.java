import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            int count = arr[i];

            for(int j=0; j<N; j++) {
                if(answer[j] == 0) {
                    if(count == 0) {
                        answer[j] = i+1;
                        break;
                    }
                    count--;
                }
            }
        }

        Arrays.stream(answer).forEach(s -> System.out.print(s + " "));

        br.close();
    }
}
