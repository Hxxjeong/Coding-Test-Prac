// Level1 �ڿ��� ������ �迭�� �����

public class No6_ReverseArray {
	public int[] solution(long n) {
		
//		�Ű������� String���� ����
		String str = Long.toString(n);
		
//		���ڿ� ���̸�ŭ�� �迭 ����
		int[] answer = new int[str.length()];
		
//		����� �迭�� �ֱ�(charAt ������� ASCII 0�� ���� ���־�� ��.)
		for(int i=0; i<str.length(); i++) {
			answer[i] = str.charAt(str.length() - 1 - i) - '0';
		}
		
        return answer;
    }

	public static void main(String[] args) {
//		No6_ReverseArray r = new No6_ReverseArray();
//		System.out.println(r.solution(123));
	}

}
