import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Deque<Character> deque = new LinkedList<>();
        boolean tag = false;    // 태그 검사를 위한 변수

        for(char c: input.toCharArray()) {
            if (c == '<') {
                tag = true; // 태그 시작
                printWord(deque);   // 덱에 있는 일반 단어 출력 (앞서 저장했던 단어)
                deque.offer(c); // 시작 태그 덱에 추가
            }
            else if (c == '>' && tag) {
                printTag(deque);    // 태그 안의 문자 출력
                System.out.print(c);    // 끝 태그 출력
                tag = false;    // 태그 끝
            }
            else if (c == ' ' && !tag) {    // 태그 밖의 문자
                printWord(deque);   // 공백 전의 일반 단어 출력
                System.out.print(c);    // 공백 출력
            }
            else { // 그 외에는 deque에 추가 (태그 인의 단어나 일반 단어)
                deque.addLast(c);
            }
        }

        // 덱에 남아있는 나머지 단어 출력
        while(!deque.isEmpty()) {
            printWord(deque);
        }

        br.close();
    }

    // 태그 출력
    public static void printTag(Deque<Character> deque) {
        while(!deque.isEmpty()) {
            System.out.print(deque.pollFirst());    // 순서대로 출력
        }
    }

    // 단어 출력
    public static void printWord(Deque<Character> deque) {
        while(!deque.isEmpty()) {
            System.out.print(deque.pollLast()); // 뒤집어서 출력
        }
    }
}