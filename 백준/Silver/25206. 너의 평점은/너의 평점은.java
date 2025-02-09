import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0;
        double totalScore = 0;

        for(int i=0; i<20; i++) {
            String[] input = br.readLine().split(" ");
            double score = Double.parseDouble(input[1]);
            String grade = input[2];

            switch(grade) {
                case "A+": totalScore += score * 4.5; sum += score; break;
                case "A0": totalScore += score * 4.0; sum += score; break;
                case "B+": totalScore += score * 3.5; sum += score; break;
                case "B0": totalScore += score * 3.0; sum += score; break;
                case "C+": totalScore += score * 2.5; sum += score; break;
                case "C0": totalScore += score * 2.0; sum += score; break;
                case "D+": totalScore += score * 1.5; sum += score; break;
                case "D0": totalScore += score; sum += score; break;
                case "F": sum += score; break;
                case "P": break;
            }
        }

        System.out.printf("%.6f", totalScore / sum);

        br.close();
    }
}
