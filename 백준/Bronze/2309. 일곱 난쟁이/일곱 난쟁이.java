import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        for(int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int sum = Arrays.stream(arr).sum();

        a: for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                if(arr[i] + arr[j] == sum - 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    break a;
                }
            }
        }

        Arrays.sort(arr);
        for(int i=0; i<9; i++) {
            if(arr[i] != 0) System.out.println(arr[i]);
        }

        br.close();
    }
}