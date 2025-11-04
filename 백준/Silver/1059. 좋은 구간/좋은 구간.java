import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        long contain = Arrays.stream(arr).filter(a -> a == n).count();
        if(contain > 0) {
            System.out.println(0);
            return;
        }

        int a = 0;  // n보다 작은 수 중 최대
        int b = 1001;   // n보다 큰 수 중 최소
        for(int i: arr) {
            if(i < n) a = Math.max(a, i);
            else if(i > n) {
                b = Math.min(b, i);
                break;  // 정렬되어 있으므로 첫번째에서 끝
            }
        }

        int answer = (n-a) * (b-n) - 1;   // 왼쪽에서 올 수 있는 시작점의 개수 * 오른쪽에서 올 수 있는 끝점의 개수
        System.out.println(answer);

        br.close();
    }
}
