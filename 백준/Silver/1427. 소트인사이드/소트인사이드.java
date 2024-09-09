import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        Arrays.sort(chars);

        for(char c : chars) {
            sb.append(c);
        }

        System.out.println(sb.reverse());

        sc.close();
    }
}