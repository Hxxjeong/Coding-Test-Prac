import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        if(arr.length == 1) {
            arr[0] = -1;
            return arr;
        }
        
        // 최소값 
        int min = arr[0];        
        for(int i: arr) {
            if(min > i)
                min = i;
        }
        
        // 최소값이 아닐 때 list에 추가
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != min)
                list.add(arr[i]);
        }
        
        // list to array
        int[] newArr = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            newArr[i] = list.get(i);
        }
        
        return newArr;
    }
}