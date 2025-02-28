import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> people = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            people.add(new int[]{weight, height});
        }

        int[] answer = new int[N];
        Arrays.fill(answer, 1);

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i == j) continue; // 자기 자신은 비교하지 않음

                if(people.get(i)[0] < people.get(j)[0] && people.get(i)[1] < people.get(j)[1]) answer[i]++;
            }
        }

        Arrays.stream(answer).forEach(s -> System.out.print(s + " "));
        
        br.close();
    }
}