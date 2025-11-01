import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        String vowel = ".*[aeiou].*";            // 모음 포함
        String vowel3 = ".*[aeiou]{3}.*";        // 모음 3연속
        String consonant3 = ".*[^aeiou]{3}.*";   // 자음 3연속
        String doubles = ".*([^eo])\\1.*";        // 같은 글자 2번 (ee, oo 제외)

        StringBuilder sb = new StringBuilder();
        while(!(input = br.readLine()).equals("end")) {
            boolean hasVowel = input.matches(vowel);
            boolean has3Vowel = input.matches(vowel3);
            boolean has3Consonant = input.matches(consonant3);
            boolean hasBadDouble = input.matches(doubles);

            if (hasVowel && !has3Vowel && !has3Consonant && !hasBadDouble)
                sb.append("<").append(input).append("> is acceptable.").append("\n");
            else sb.append("<").append(input).append("> is not acceptable.").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
