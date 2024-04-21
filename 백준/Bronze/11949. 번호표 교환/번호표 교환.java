import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();  // 학생 및 카드 수
        String[] stuAndCard = input.split(" ");

        // 번호표 배열
        int[] numbers = new int[Integer.parseInt(stuAndCard[0])];
        for(int i=0; i<Integer.parseInt(stuAndCard[0]); i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=Integer.parseInt(stuAndCard[1]); i++) {
            for(int j=0; j<numbers.length-1; j++) {
                if (numbers[j] % i > numbers[j + 1] % i)
                    swap(numbers, j, j + 1);
            }
        }

        for(int i: numbers)
            System.out.println(i);

        br.close();
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}