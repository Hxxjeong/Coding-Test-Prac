import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int answer = 0;
        int count = 0;

        for(int i=1; i<M-1; i++) {
            // IOI 패턴인지 확인
            if(S.charAt(i-1) == 'I' && S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
                count++;

                if(count == N) {
                    answer++;
                    count--; // 겹치는 패턴을 위해 1 감소
                }

                i++; // IOI에서 I까지 본 뒤 다음 O를 건너뜀
            }
            else count = 0; // 연속 패턴 아니면 초기화
        }

        System.out.println(answer);

        br.close();
    }
}