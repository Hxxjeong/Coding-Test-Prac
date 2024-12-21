import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] count = new int[8001];
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
            count[input+4000]++;
        }

        Arrays.sort(arr);

        int avg = (int) Math.round(Arrays.stream(arr).sum() / (double) N);
        int mid = arr[N/2];

        int maxFreq = Arrays.stream(count).max().getAsInt();
        int mostFreq = 0;
        boolean foundSecond = false;
        for(int i=0; i<count.length; i++) {
            if(count[i] == maxFreq) {
                mostFreq = i-4000;
                if(!foundSecond) foundSecond = true;    // 첫번째로 작은 최빈값
                else break;     // 두번째로 작은 최빈값이 있는 경우
            }
        }

        int range = arr[N-1] - arr[0];

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(mostFreq);
        System.out.println(range);
        
        br.close();
    }
}
