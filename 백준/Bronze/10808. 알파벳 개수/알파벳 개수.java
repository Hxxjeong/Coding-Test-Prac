import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alphabet = new int[26];   // 알파벳이 나온 횟수

        for(char c: input.toCharArray())
            alphabet[c-'a']++;  // 문자열을 돌면서 해당 인덱스에 횟수 추가

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i: alphabet) bw.write(i + " ");

        bw.close();
        br.close();
    }
}