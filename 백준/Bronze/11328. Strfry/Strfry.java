import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i=0; i<N; i++){
            int[] alphabet = new int[26];
            char[] word1 = sc.next().toCharArray();
            char[] word2 = sc.next().toCharArray();

            for (char ch: word1) alphabet[ch-'a']++;
            for (char ch: word2) alphabet[ch-'a']--;

            boolean flag = true;
            for (int j: alphabet)
                if(j != 0) {
                    flag = false;
                    break;
                }
            System.out.println(flag ? "Possible" : "Impossible");
        }

        sc.close();
    }
}