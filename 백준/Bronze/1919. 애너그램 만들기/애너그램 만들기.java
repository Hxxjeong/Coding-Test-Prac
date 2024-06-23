import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();

        int[] alphabet = new int[26];
        for(char c: word1.toCharArray()) alphabet[c-'a']++;
        for(char c: word2.toCharArray()) alphabet[c-'a']--;

        int answer = 0;
        for(int i: alphabet) {
            if(i != 0) answer += Math.abs(i);
        }

        System.out.println(answer);

        sc.close();
    }
}