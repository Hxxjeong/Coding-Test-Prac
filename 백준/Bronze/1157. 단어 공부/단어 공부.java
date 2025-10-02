import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase();

        int[] arr = new int[26];
        for(char c: input.toCharArray()) arr[c-'a']++;

        int max = Arrays.stream(arr).max().getAsInt();
        long count = Arrays.stream(arr).filter(s -> s == max).count();
        if(count >= 2) {
            System.out.println("?");
            return;
        }

        int answer = 0;
        for(int i=0; i<26; i++) {
            if(arr[i] == max) {
                answer = i + 'A';
                break;
            }
        }

        System.out.println((char) answer);

        br.close();
    }
}