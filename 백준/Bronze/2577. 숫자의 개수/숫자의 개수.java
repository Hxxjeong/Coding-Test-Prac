import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        String result = String.valueOf(a*b*c);

        int[] nums = new int[10];

        for(int i=0; i<result.length(); i++) {
            nums[result.charAt(i)-'0']++;
        }

        Arrays.stream(nums)
                .forEach(System.out::println);
    }
}