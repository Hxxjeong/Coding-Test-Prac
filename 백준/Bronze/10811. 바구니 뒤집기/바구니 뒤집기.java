import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = i+1;

        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0])-1;
            int end = Integer.parseInt(input[1])-1;
            while(start < end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        for(int i=0; i<N; i++) System.out.print(arr[i] + " ");

        br.close();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}