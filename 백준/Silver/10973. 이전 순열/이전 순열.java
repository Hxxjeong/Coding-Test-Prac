import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(input[i]);

        if(prePermutation(arr)) {
            StringBuilder sb = new StringBuilder();
            for(int num: arr) sb.append(num).append(" ");
            System.out.println(sb);
        }
        // 첫 번째 순열인 경우 -1 출력
        else {
            System.out.println(-1);
        }

        br.close();
    }

    public static boolean prePermutation(int[] arr) {
        int i = arr.length - 2;

        // 내림차순이 깨지는 지점 찾기
        while (i >= 0 && arr[i] <= arr[i+1]) {
            i--;
        }

        // 첫 번째 순열인 경우
        if(i < 0) return false;

        // i 위치 값보다 작은 값 찾기
        int j = arr.length - 1;
        while(arr[j] >= arr[i]) {
            j--;
        }

        // i와 j 위치 교환
        swap(arr, i, j);

        // i+1부터 끝까지 내림차순 정렬
        reverse(arr, i+1, arr.length-1);

        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            swap(arr, start++, end--);
        }
    }
}