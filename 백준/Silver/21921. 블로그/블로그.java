import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sums = new int[N+1];

        sums[1] = arr[0];
        for(int i=2; i<=N; i++) sums[i] = sums[i-1] + arr[i-1];

        int answer = 0;
        int count = 0;
        for(int i=X; i<=N; i++) {
            int person = sums[i] - sums[i-X];

            if(person > answer) {
                answer = person;
                count = 1;
            }
            else if(person == answer) count++;
        }

        if(answer == 0) System.out.println("SAD");
        else {
            System.out.println(answer);
            System.out.println(count);
        }

        br.close();
    }
}
