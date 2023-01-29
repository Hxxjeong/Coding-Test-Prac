
public class No14_MinRectangle {
	
	public int solution(int[][] sizes) {
        int answer = 0;
        
        int w = 0;
        int h = 0;
        
        for (int[] size: sizes) {
            if (size[0] > size[1]) {
                int tmp = size[0];
                size[0] = size[1];
                size[1] = tmp;
            }
            w = Math.max(w, size[1]);
            h = Math.max(h, size[0]);
        }
        
        answer = w * h;
        
        return answer;
    }

	public static void main(String[] args) {
		No14_MinRectangle m = new No14_MinRectangle();
		System.out.println(m.solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
	}

}
