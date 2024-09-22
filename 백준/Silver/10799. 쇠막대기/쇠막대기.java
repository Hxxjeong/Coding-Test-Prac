import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = 0;
        int openStick = 0;

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            if(c == '(') {
                openStick++;
            }
            else {
                openStick--;

                // '()'인 경우 (레이저인 경우)
                if(input.charAt(i-1) == '(') {
                    answer += openStick; // 현재 열려 있는 막대가 잘림
                }
                else answer += 1;   // 막대기의 끝인 경우
            }
        }

        System.out.println(answer);

        br.close();
    }
}