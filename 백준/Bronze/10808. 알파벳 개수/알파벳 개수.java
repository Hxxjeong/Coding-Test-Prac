import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alphabet = new int[26];
        for(int i=0; i<input.length(); i++) {
            alphabet[input.charAt(i)-'a']++;
        }

        for(int i: alphabet) System.out.print(i + " ");

        br.close();
    }
}