import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] words = new String[input.length()];

        for(int i=0; i<words.length; i++) {
            words[i] = input.substring(i);
        }

        Arrays.sort(words);
        for(String s: words) System.out.println(s);

        br.close();
    }
}