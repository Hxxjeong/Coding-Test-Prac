import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String scores  = br.readLine();
        String[] s = scores.split(" ");
        double[] score = new double[s.length];

        for(int i=0; i<s.length; i++) {
            score[i] = Double.parseDouble(s[i]);
        }

        double max = score[0];
        for(double i: score) {
            if(i > max)
                max = i;
        }

        for(int i=0; i<score.length; i++) {
            score[i] = score[i]/max*100;
        }

        double sum = 0;
        for(double d: score) {
            sum += d;
        }

        System.out.println(sum/num);
    }
}