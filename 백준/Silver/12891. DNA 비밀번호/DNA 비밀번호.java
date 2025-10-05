import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int S = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);

        String str = br.readLine();

        int[] dna = Arrays.stream(br.readLine().split(" "))    // ACGT
                .mapToInt(Integer::parseInt)
                .toArray();

        // 초기 부분 문자열
        for(int i=0; i<P; i++) {
            update(str.charAt(i), dna, -1);
        }

        int answer = 0;
        if(isPassword(dna)) answer++;

        for (int i=P; i<S; i++) {
            update(str.charAt(i-P), dna, +1); // 빠지는 문자
            update(str.charAt(i), dna, -1);   // 들어오는 문자
            if(isPassword(dna)) answer++;
        }

        System.out.println(answer);

        br.close();
    }

    static void update(char c, int[] dna, int diff) {
        switch (c) {
            case 'A': dna[0] += diff; break;
            case 'C': dna[1] += diff; break;
            case 'G': dna[2] += diff; break;
            case 'T': dna[3] += diff; break;
        }
    }

    static boolean isPassword(int[] dna) {
        for(int n: dna) {
            if(n > 0) return false;
        }

        return true;
    }

}
