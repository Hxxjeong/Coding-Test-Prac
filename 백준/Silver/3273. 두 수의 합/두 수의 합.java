import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }
        int x = Integer.parseInt(br.readLine());

        Collections.sort(list);

        int left = 0;
        int right = n-1;
        int count = 0;

        while(left < right) {
            int sum = list.get(left) + list.get(right);
            if(sum > x)
                right--;
            else if(sum < x)
                left++;
            else {
                count++;
                left++;
                right--;
            }
        }

        System.out.println(count);

        br.close();
    }
}
