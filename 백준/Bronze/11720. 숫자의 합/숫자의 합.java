import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String numbers = sc.next();

        int[] arr = new int[numbers.length()];
        int sum = 0;

        for (int i=0; i<numbers.length(); i++) {
            String[] str = numbers.split("");
            arr[i] = Integer.parseInt(str[i]);
            sum += arr[i];
        }

        System.out.println(sum);
    }
}