import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            int count = 0;
            int n = Integer.parseInt(br.readLine());
            for(int j=0; j<n; j++) {
                input = br.readLine().split(" ");
                int cx = Integer.parseInt(input[0]);
                int cy = Integer.parseInt(input[1]);
                int r = Integer.parseInt(input[2]);

                boolean startIn = isInside(x1, y1, cx, cy, r);
                boolean endIn = isInside(x2, y2, cx, cy, r);

                if(startIn != endIn) count++;   // 같지 같으면 경계선 통과한 경우
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    // 한 점(x, y)이 원((x-a)^2 + (y-b)^2 = r^2) 안에 있는지 확인
    private static boolean isInside(int x, int y, int cx, int cy, int r) {
        int dx = x - cx;
        int dy = y - cy;
        return dx * dx + dy * dy < r * r;
    }
}