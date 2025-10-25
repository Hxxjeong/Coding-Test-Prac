import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int count = 0;
    static int answer = -1;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        temp = new int[N];
        sort(arr, 0, N-1);

        System.out.println(answer);

        br.close();
    }

    private static void sort(int[] arr, int left, int right) {
        if (count >= K) return;

        if(left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);    // 전반부 정렬
            sort(arr, mid+1, right);  // 후반부 정렬
            merge(arr, left, mid, right);    // 병합
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while(i <= mid) temp[k++] = arr[i++];
        while(j <= right) temp[k++] = arr[j++];

        for(int l=left; l<=right; l++) {
            arr[l] = temp[l];
            count++;
            if(count == K) {
                answer = arr[l];
                return;
            }
        }
    }
}