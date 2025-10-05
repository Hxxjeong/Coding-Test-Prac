import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[] dir = new int[6];
        int[] len = new int[6];

        for(int i=0; i<6; i++) {
            String[] input = br.readLine().split(" ");
            dir[i] = Integer.parseInt(input[0]);
            len[i] = Integer.parseInt(input[1]);
        }

        int totalW = 0, totalH = 0;
        int idxW = -1, idxH = -1;

        // 가장 큰 가로, 세로 변과 인덱스 찾기
        for(int i=0; i<6; i++) {
            if(dir[i] == 1 || dir[i] == 2) {   // 가로
                if(len[i] > totalW) {
                    totalW = len[i];
                    idxW = i;
                }
            }
            else {  // 세로
                if(len[i] > totalH) {
                    totalH = len[i];
                    idxH = i;
                }
            }
        }

        int smallW = Math.abs(len[(idxW+5) % 6] - len[(idxW+1) % 6]);   // 이전 변과 다음 변의 차이
        int smallH = Math.abs(len[(idxH+5) % 6] - len[(idxH+1) % 6]);

        int answer = (totalW * totalH - smallW * smallH) * K;
        System.out.println(answer);

        br.close();
    }
}
