import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String[] numbers = br.readLine().split(" ");

        // 각 인덱스까지의 합 배열에 저장
        int[] sums = new int[numbers.length+1];
        int sum = 0;
        for(int i=1; i<sums.length; i++) {
            sum += Integer.parseInt(numbers[i-1]);
            sums[i] = sum;
        }

        List<Integer> sumList = new ArrayList<>();
        for(int i=0; i<Integer.parseInt(input[1]); i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sumList.add(sums[end] - sums[start-1]);
        }

        sumList.forEach(System.out::println);
    }
}