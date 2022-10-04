// Level1 자연수 뒤집어 배열로 만들기

public class No6_ReverseArray {
	public int[] solution(long n) {
		
//		매개변수를 String으로 변경
		String str = Long.toString(n);
		
//		문자열 길이만큼의 배열 생성
		int[] answer = new int[str.length()];
		
//		뒤집어서 배열에 넣기(charAt 사용으로 ASCII 0의 값을 뺴주어야 함.)
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
