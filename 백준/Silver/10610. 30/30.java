import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        List<Character> list = new ArrayList<>();
        for(char c: N.toCharArray()) list.add(c);

        if(!list.contains('0')) {
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for(Character c: list) sum += c - '0';
        if(sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        list.sort(Collections.reverseOrder());
        for(Character c: list) System.out.print(c);

        br.close();
    }
}