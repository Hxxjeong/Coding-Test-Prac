import java.io.*;

public class Main {
    static int[] arr = new int[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

        // 1부터 10까지: 0 1 1 2 3 2 3 3 2 3
        // 2나 3으로 나뉘는 경우 이전의 인덱스를 참고해서 더 작은 값 / 그렇지 않으면 1을 뺀 인덱스 값 참고
        for(int i=4; i<arr.length; i++) {
            if(i % 3 == 0 && i % 2 == 0) {
                arr[i] = Math.min(arr[i/3], arr[i/2]) + 1;
            }
            else if(i % 3 == 0) arr[i] = Math.min(arr[i/3] + 1, arr[i-1] + 1);
            else if(i % 2 == 0) arr[i] = Math.min(arr[i/2] + 1, arr[i-1] + 1);
            else arr[i] = arr[i-1] + 1;
        }

        System.out.println(arr[N]);

        br.close();
    }
}