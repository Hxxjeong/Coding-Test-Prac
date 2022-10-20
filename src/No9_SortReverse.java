import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Level1 ���� ������������ ��ġ�ϱ�
public class No9_SortReverse {
	
	public long solution(long n) {
        String answer = "";
        List<Long> list = new ArrayList<>();

//      ������� ����
        while(n != 0){
            list.add(n % 10);
            n /= 10;
        }

//      �������� ����
        Collections.sort(list, Collections.reverseOrder());

//      list�� ���� ���
        for(int i=0; i<list.size(); i++){
            answer += Long.toString(list.get(i));
        }

//      long type���� ���
        return Long.parseLong(answer);
	}

	public static void main(String[] args) {
		No9_SortReverse s = new No9_SortReverse();
		System.out.println(s.solution(9787));
	}

}
