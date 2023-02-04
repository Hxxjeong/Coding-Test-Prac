import java.util.*;

public class No15_NoK {

	public int[] solution(int[] array, int[][] commands) {
        int answer[] = new int[commands.length];
        
        for (int i=0; i<answer.length; i++) {
            int first = commands[i][0];
            int second = commands[i][1];
            int third = commands[i][2];
            
            int[] newArray = new int[second-first+1];
            
            for (int j=0; j<=second-first; j++) {
                newArray[j] = array[j+first-1];
            }
            
            Arrays.sort(newArray);
            answer[i] = newArray[third-1];
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		No15_NoK n = new No15_NoK();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] cmd = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(Arrays.toString(n.solution(array, cmd)));
	}

}
