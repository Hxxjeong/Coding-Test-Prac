// Level �ϻ��� ��
public class No8_HarshadNo {
	
	public boolean solution(int x) {
		
		int n = x;
		
//      �� �ڸ����� ��
        int sum = 0;
        while(n > 0)
        {
            sum += n % 10;
            n = n / 10;
        }
        
//      �ϻ��� ���� ������ true return
        return x%sum == 0 ? true : false;
    }

	public static void main(String[] args) {
		No8_HarshadNo h = new No8_HarshadNo();
		System.out.println(h.solution(11));
	}

}
