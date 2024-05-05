import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nanjaeng = new int[9];
        for(int i=0; i<9; i++) {
            nanjaeng[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nanjaeng);

        int sum = Arrays.stream(nanjaeng).sum();

        int falseNanjaeng1 = 0;
        int falseNanjaeng2 = 0;

        // 전체 합에서 두 개의 합을 뺐을 때 100이 나오는 경우의 수
        a:for(int i=0; i<9; i++) {
            for(int j=1; j<9; j++) {
                if(sum - (nanjaeng[i] + nanjaeng[j]) == 100) {
                    falseNanjaeng1 = nanjaeng[i];
                    falseNanjaeng2 = nanjaeng[j];
                    break a;
                }
            }
        }

        // 거짓 난쟁이 둘을 빼고 리스트에 추가
        for(int i=0; i<9; i++) {
            if (nanjaeng[i] != falseNanjaeng1 && nanjaeng[i] != falseNanjaeng2)
                System.out.println(nanjaeng[i]);
        }

        br.close();
    }
}