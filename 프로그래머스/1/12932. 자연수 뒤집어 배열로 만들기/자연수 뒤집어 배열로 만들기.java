class Solution {
    public int[] solution(long n) {
		
		String str = Long.toString(n);
		
		int[] answer = new int[str.length()];
		
		// 뒤집어서 배열에 넣기(charAt 사용으로 ASCII 0의 값을 뺴주어야 함.)
		for(int i=0; i<str.length(); i++) {
			answer[i] = str.charAt(str.length()-1-i) - '0';
		}
		
        return answer;
    }
}