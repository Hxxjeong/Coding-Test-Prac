import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        String str = br.readLine();
        char[] charArray = str.toCharArray();
        List<Character> list = new LinkedList<>();
        for(char c: charArray) list.add(c);
        ListIterator<Character> iter = list.listIterator(list.size());

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++) {
            String input = br.readLine();

            switch (input.charAt(0)) {
                case 'L': // 이전 문자가 있을 때만 커서 이동
                    if(iter.hasPrevious()) iter.previous();
                    break;
                case 'D': // 이후 문자가 있을 때만 커서 이동
                    if(iter.hasNext()) iter.next();
                    break;
                case 'B': // 이전 문자가 있을 때만 삭제
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P': // 문자 추가
                    iter.add(input.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list) sb.append(c);
        System.out.println(sb);

        br.close();
    }
}