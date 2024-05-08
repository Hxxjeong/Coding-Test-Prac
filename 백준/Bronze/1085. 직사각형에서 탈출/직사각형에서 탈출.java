import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nowX = Integer.parseInt(st.nextToken());
        int nowY = Integer.parseInt(st.nextToken());
        int racX = Integer.parseInt(st.nextToken());
        int racY = Integer.parseInt(st.nextToken());

        int distanceX = Math.min(nowX, Math.abs(racX-nowX));
        int distanceY = Math.min(nowY, Math.abs(racY-nowY));

        int distance = Math.min(distanceX, distanceY);
        System.out.println(distance);
        
        br.close();
    }
}