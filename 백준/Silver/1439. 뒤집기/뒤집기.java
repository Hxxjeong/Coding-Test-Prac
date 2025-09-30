import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        char prev = input.charAt(0);
        map.put(prev, 1);
        for(int i=1; i<input.length(); i++) {
            if(prev != input.charAt(i)) {
                prev = input.charAt(i);
                map.put(prev, map.getOrDefault(prev, 0)+1);
            }
        }

        int zero = map.getOrDefault('0', 0);
        int one = map.getOrDefault('1', 0);
        System.out.println(Math.min(zero, one));

        br.close();
    }
}