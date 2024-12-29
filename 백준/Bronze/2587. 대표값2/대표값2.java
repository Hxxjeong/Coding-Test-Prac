import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];
        for(int i=0; i<5; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int avg = Arrays.stream(arr).sum() / 5;
        int mid = arr[2];

        System.out.println(avg);
        System.out.println(mid);

        br.close();
    }
}
