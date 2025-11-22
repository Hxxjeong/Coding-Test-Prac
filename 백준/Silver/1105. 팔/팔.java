import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String L = input[0];
        String R = input[1];

        if(L.length() != R.length()) {  // 자릿수가 다르면 모두 8이 아닌 숫자 가능
            System.out.println(0);
            return;
        }

        int answer = 0;
        for(int i=0; i<L.length(); i++) {
            if(L.charAt(i) == R.charAt(i)) {
                if(L.charAt(i) == '8') answer++;
            }
            else break;
        }

        System.out.println(answer);

        br.close();
    }
}
