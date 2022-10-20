import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Level1 정수 내림차순으로 배치하기
public class No9_SortReverse {
	
	public long solution(long n) {
        String answer = "";
        List<Long> list = new ArrayList<>();

//      순서대로 저장
        while(n != 0){
            list.add(n % 10);
            n /= 10;
        }

//      역순으로 정렬
        Collections.sort(list, Collections.reverseOrder());

//      list의 내용 출력
        for(int i=0; i<list.size(); i++){
            answer += Long.toString(list.get(i));
        }

//      long type으로 출력
        return Long.parseLong(answer);
	}

	public static void main(String[] args) {
		No9_SortReverse s = new No9_SortReverse();
		System.out.println(s.solution(9787));
	}

}
