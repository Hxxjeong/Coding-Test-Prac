import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int[] num = new int[9];
            String[] input = br.readLine().split(" ");
            for(int j=0; j<input.length; j++) num[j] = Integer.parseInt(input[j]);
            num[8] += num[5];
            num[5] = 0;

            int n = Arrays.stream(num).sum();
            int[] answer = new int[n];
            int index = 8;

            int left = 0;
            int right = n-1;
            int prev = right;

            while(left <= right) {
                if(num[index] > 0) {
                    if (prev == right) {
                        answer[left++] = index+1;
                        prev = left;
                    }
                    else {
                        answer[right--] = index+1;
                        prev = right;
                    }
                    num[index]--;
                }
                else index--;
            }

            Arrays.stream(answer).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }

        br.close();
    }
}
