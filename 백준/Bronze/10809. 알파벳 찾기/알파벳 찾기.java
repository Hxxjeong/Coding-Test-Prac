import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alphabet = new int[26];   // 알파벳이 등장한 위치
        for(int i=0; i<26; i++) alphabet[i] = -1;    // 초기화

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            // 처음 나올 때만 위치 저장
            if(alphabet[c-'a'] == -1) {
                alphabet[c-'a'] = i;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i: alphabet) bw.write(i + " ");

        bw.close();
        br.close();
    }
}