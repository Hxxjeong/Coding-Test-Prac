import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int[] ints = new int[num.length()];

        for(int i=0; i<num.length(); i++) {
            ints[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }

        for(int i=ints.length-1; i>0; i--) {
            if(ints[i] >= 5) {
                ints[i-1]++;
                ints[i] = 0;
            }
            else {
                ints[i] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i: ints)
            sb.append(i);
        System.out.println(sb);

        br.close();
    }
}