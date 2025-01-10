import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=0; i<N; i++) {
            int sum = 0;
            String[] input = br.readLine().split(" ");

            int[] arr = new int[3];
            for(int j=0; j<3; j++) arr[j] = Integer.parseInt(input[j]);

            Arrays.sort(arr);
            if(arr[0] == arr[1] && arr[1] == arr[2]) sum = 10000 + arr[0] * 1000;   // 세 눈이 모두 같은 경우
                // 두 눈이 같은 경우
            else if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
                if(arr[0] == arr[1]) sum = 1000 + arr[0] * 100;
                else if(arr[0] == arr[2]) sum = 1000 + arr[0] * 100;
                else sum = 1000 + arr[1] * 100;
            }
            else sum = arr[2] * 100;  // 모두 다른 경우

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);

        br.close();
    }
}
