import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] score = br.readLine().split(" ");
        Arrays.sort(score);

        int result = Integer.parseInt(score[score.length-1]) - Integer.parseInt(score[0]);

        System.out.println(result);

        br.close();
    }
}