// Level1 두 정수 사이의 합

public class No12_BetweenIntSum {
	
	public long solution(int a, int b) {
        long answer = 0;
        if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
        }
        for (int i=a; i<=b; i++)
            answer += i;
        return answer;
    }

	public static void main(String[] args) {
		No12_BetweenIntSum b = new No12_BetweenIntSum();
		System.out.println(b.solution(3, 5));
	}

}
