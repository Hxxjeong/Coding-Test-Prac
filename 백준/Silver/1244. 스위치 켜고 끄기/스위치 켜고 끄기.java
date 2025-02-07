import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        boolean[] switches = new boolean[n];
        for(int i=0; i<n; i++) switches[i] = input[i].equals("1");

        int s = Integer.parseInt(br.readLine());
        for(int i=0; i<s; i++) {
            input = br.readLine().split(" ");
            int gender = Integer.parseInt(input[0]);    // 1: 남자, 2: 여자
            int num = Integer.parseInt(input[1])-1;

            if(gender == 1) for(int j=num; j<n; j+=num+1) switches[j] = !switches[j];
            else {
                switches[num] = !switches[num];

                int start = num - 1;
                int end = num + 1;
                while(start >= 0 && end < n) {
                    if(switches[start] == switches[end]) {
                        switches[start] = !switches[start];
                        switches[end] = !switches[end];
                    }
                    else break;

                    start--;
                    end++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(switches[i] ? 1 : 0).append(" ");
            if((i+1) % 20 == 0) sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
