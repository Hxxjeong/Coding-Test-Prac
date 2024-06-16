import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String room = br.readLine();

        int[] numbers = new int[10];

        for(char c: room.toCharArray()) {
            numbers[c-'0']++;
        }
        
        // 6와 9의 개수 고려
        if((numbers[6] + numbers[9]) % 2 == 0) {
            numbers[6] = (numbers[6] + numbers[9]) / 2;
            numbers[9] = 0;
        }
        else {
            numbers[6] = (numbers[6] + numbers[9]) / 2 + 1;
            numbers[9] = 0;
        }

        int set = Arrays.stream(numbers).max().orElse(0);
        System.out.println(set);

        br.close();
    }
}