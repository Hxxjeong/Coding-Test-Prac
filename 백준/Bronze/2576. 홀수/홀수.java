import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[7];
        for(int i=0; i<7; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num % 2 != 0) arr[i] = num;
        }

        Arrays.sort(arr);
        int sum = Arrays.stream(arr).sum();
        int min = -1;
        for(int i=1; i<arr.length; i++) {
            if(arr[i] != 0) {
                min = arr[i];
                break;
            }
        }

        if(sum == 0) {
            System.out.println(min);
            return;
        }
        else System.out.println(sum);
        
        System.out.println(min);

        br.close();
    }
}
