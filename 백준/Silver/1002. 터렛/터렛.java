import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int r1 = Integer.parseInt(input[2]);
            int x2 = Integer.parseInt(input[3]);
            int y2 = Integer.parseInt(input[4]);
            int r2 = Integer.parseInt(input[5]);

            System.out.println(calculate(x1, y1, r1, x2, y2, r2));
        }

        br.close();
    }

    public static int calculate(int x1, int y1, int r1, int x2, int y2, int r2) {
        // 원의 중심 사이의 거리
        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        int sum = r1 + r2;
        int diff = Math.abs(r1 - r2);

        if(d == 0 && r1 == r2) return -1;   // 두 원이 정확히 일치하는 경우
        else if(d < diff) return 0;  // 한 원이 다른 원 안에 포함
        else if(d > sum) return 0;  // 두 원이 서로 떨어져 있음
        else if(d == diff) return 1;  // 내접
        else if(d == sum) return 1;  // 외접
        else return 2;  // 두 원이 서로 교차
    }
}
