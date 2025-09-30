import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++) set.add(Integer.parseInt(input[i]));

        int answer = 0;
        for(int i: set) {
            if(set.contains(M-i)) answer++;
        }
        System.out.println(answer/2);

        br.close();
    }
}