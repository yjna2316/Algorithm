// S1. IntStream 이용

import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
       
        for (int i = 0; i < commands.length; ++i) {
            int[] arr = commands[i];
            int start = arr[0], end = arr[1];

            Integer[] subarr = IntStream.range(start-1, end)
                                    .mapToObj(j-> array[j])
                                    .sorted()
                                    .toArray(Integer[]::new);

            answer[i] = subarr[arr[2] - 1];
        }
        
        return answer;
    }
}

// S2. copyOfRange이용

import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
       
        for (int i = 0; i < commands.length; ++i) {
            int[] arr = commands[i];
            int start = arr[0], end = arr[1];
            int[] subarr = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(subarr);
            answer[i] = subarr[arr[2] - 1];
        }
        
        return answer;
    }
}