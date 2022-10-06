// Level 하샤드 수
public class No8_HarshadNo {
	
	public boolean solution(int x) {
		
		int n = x;
		
//      각 자릿수의 합
        int sum = 0;
        while(n > 0)
        {
            sum += n % 10;
            n = n / 10;
        }
        
//      하샤드 수가 맞으면 true return
        return x%sum == 0 ? true : false;
    }

	public static void main(String[] args) {
		No8_HarshadNo h = new No8_HarshadNo();
		System.out.println(h.solution(11));
	}

}
