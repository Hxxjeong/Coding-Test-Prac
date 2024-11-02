import java.io.*;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] days = new int[N];
        int[] price = new int[N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            days[i] = Integer.parseInt(input[0]);
            price[i] = Integer.parseInt(input[1]);
        }

        dfs(days, price, 0, 0);
        System.out.println(max);

        br.close();
    }

    public static void dfs(int[] days, int[] price, int day, int sum) {
        if(day >= N) {
            max = Math.max(max, sum);
            return;
        }

        // 현재 상담을 선택하는 경우
        if (day + days[day] <= N) {
            dfs(days, price, day+days[day], sum+price[day]);
        }

        // 현재 상담을 선택하지 않는 경우 다음 날로 이동
        dfs(days, price, day+1, sum);
    }
}