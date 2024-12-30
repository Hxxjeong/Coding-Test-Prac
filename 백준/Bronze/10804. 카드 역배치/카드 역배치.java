import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=20; i++) list.add(i);

        for(int i=0; i<10; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0])-1;
            int end = Integer.parseInt(input[1])-1;

            while(start <= end) {
                Collections.swap(list, start, end);
                start++;
                end--;
            }
        }

        list.forEach(s -> System.out.print(s + " "));

        br.close();
    }
}
