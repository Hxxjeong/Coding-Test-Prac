import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int[] arr = new int[3];
        for(int i=0; i<3; i++) arr[i] = Integer.parseInt(input[i]);

        Arrays.sort(arr);
        System.out.println(arr[1]);

        br.close();
    }
}