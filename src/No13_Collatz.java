
public class No13_Collatz {

	public int solution(int num) {

		long n = num;
		int answer = 0;

		while (n != 1) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = n * 3 + 1;
			}
			answer++;
			if (answer == 500) {
				answer = -1;
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		No13_Collatz c = new No13_Collatz();
		System.out.println(c.solution(6));

	}

}
