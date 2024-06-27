import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 큐의 크기
        int M = Integer.parseInt(input[1]); // 뽑아내려는 숫자의 개수

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1; i<=N; i++) deque.offer(i);

        String nums = br.readLine();
        StringTokenizer st = new StringTokenizer(nums);

        int count = 0;
        while(M-- != 0) {
            int num = Integer.parseInt(st.nextToken());

            int index = 0;
            for(int i=0; i<deque.size(); i++) {
                if (deque.get(i) == num) {
                    index = i;
                    break;
                }
            }

            while(deque.peekFirst() != num) {
                if(index > deque.size()/2 ) {   // 찾으려는 인덱스가 절반보다 뒤에 있는 경우
                    deque.offerFirst(deque.pollLast()); // 뒤에서 뽑아서 앞으로 이동
                }
                else {  // 찾으려는 인덱스가 절반보다 앞에 있는 경우
                    deque.offerLast(deque.pollFirst()); // 앞에서 뽑아서 뒤로 이동
                }
                count++;
            }
            deque.pollFirst();  // head과 같은 값이면 제거
        }

        System.out.println(count);

        br.close();
    }
}