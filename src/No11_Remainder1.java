// Level1 나머지가 1이 되는 수 찾기

public class No11_Remainder1 {

	public int solution(int n) {
		int answer = 0;
		int i = 2;
        while(i <= n) {
        	if(n%i == 1) {
        		answer = i;
        		break;
        	}
        	i++;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		No11_Remainder1 r = new No11_Remainder1();
		System.out.println(r.solution(135465));
	}

}
